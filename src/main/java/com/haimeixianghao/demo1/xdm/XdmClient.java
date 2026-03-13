package com.haimeixianghao.demo1.xdm;

import com.haimeixianghao.demo1.config.XdmProperties;
import com.haimeixianghao.demo1.xdm.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class XdmClient {

    private static final Logger log = LoggerFactory.getLogger(XdmClient.class);
    private final RestClient restClient;
    private final XdmProperties props;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public XdmClient(RestClient restClient, XdmProperties props) {
        this.restClient = restClient;
        this.props = props;
    }

    /**
     * Create an entity via XDM API.
     * POST /{entityName}/create
     */
    public <T> T create(String entityName, Object createDto, Class<T> responseType) {
        RDMParamVO<Object> body = wrap(createDto);
        String json = postWithRetry("/" + entityName + "/create", body);
        return parseResult(json, responseType);
    }

    /**
     * Get a single entity by ID.
     * POST /{entityName}/get
     */
    public <T> T get(String entityName, String id, Class<T> responseType) {
        PersistObjectIdDecryptDTO param = new PersistObjectIdDecryptDTO(id);
        RDMParamVO<PersistObjectIdDecryptDTO> body = wrap(param);
        String json = postWithRetry("/" + entityName + "/get", body);
        return parseResult(json, responseType);
    }

    /**
     * Find entities with pagination.
     * POST /{entityName}/find/{curPage}/{pageSize}
     */
    public <T> List<T> find(String entityName, QueryRequestVo query, int curPage, int pageSize, Class<T> responseType) {
        RDMParamVO<QueryRequestVo> body = wrap(query);
        String json = postWithRetry("/" + entityName + "/find/" + curPage + "/" + pageSize, body);
        return parseResultList(json, responseType);
    }

    /**
     * Find all entities (large page).
     * POST /{entityName}/find/1/10000
     */
    public <T> List<T> findAll(String entityName, Class<T> responseType) {
        QueryRequestVo query = new QueryRequestVo(Collections.emptyList());
        return find(entityName, query, 1, 10000, responseType);
    }

    /**
     * Update an entity.
     * POST /{entityName}/update
     */
    public <T> T update(String entityName, Object updateDto, Class<T> responseType) {
        RDMParamVO<Object> body = wrap(updateDto);
        String json = postWithRetry("/" + entityName + "/update", body);
        return parseResult(json, responseType);
    }

    /**
     * Delete an entity by ID.
     * POST /{entityName}/delete
     */
    public int delete(String entityName, String id, String modifier) {
        PersistObjectIdModifierDTO param = new PersistObjectIdModifierDTO(id, modifier);
        RDMParamVO<PersistObjectIdModifierDTO> body = wrap(param);
        String json = postWithRetry("/" + entityName + "/delete", body);
        try {
            JsonNode node = objectMapper.readTree(json);
            return node.has("result") ? node.get("result").asInt() : 0;
        } catch (Exception e) {
            log.error("Failed to parse delete response", e);
            return 0;
        }
    }

    private <T> RDMParamVO<T> wrap(T params) {
        return new RDMParamVO<>(props.getApplicationId(), params);
    }

    private String postWithRetry(String uri, Object body) {
        int maxAttempts = props.getRetry().getMaxAttempts();
        int backoffMs = props.getRetry().getBackoffMs();
        Exception lastException = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                String result = restClient.post()
                        .uri(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(body)
                        .retrieve()
                        .body(String.class);
                return result;
            } catch (Exception e) {
                lastException = e;
                log.warn("XDM request failed (attempt {}/{}): {} {}", attempt, maxAttempts, uri, e.getMessage());
                if (attempt < maxAttempts) {
                    try {
                        Thread.sleep((long) backoffMs * attempt);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Interrupted during retry backoff", ie);
                    }
                }
            }
        }
        throw new RuntimeException("XDM request failed after " + maxAttempts + " attempts: " + uri, lastException);
    }

    private <T> T parseResult(String json, Class<T> type) {
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode data = root.has("data") ? root.get("data") : root;
            return objectMapper.treeToValue(data, type);
        } catch (Exception e) {
            log.error("Failed to parse XDM response to {}", type.getSimpleName(), e);
            throw new RuntimeException("Failed to parse XDM response", e);
        }
    }

    private <T> List<T> parseResultList(String json, Class<T> type) {
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode data = root.has("data") ? root.get("data") : root;
            if (data.isArray()) {
                return objectMapper.readValue(data.traverse(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, type));
            }
            return Collections.emptyList();
        } catch (Exception e) {
            log.error("Failed to parse XDM list response to {}", type.getSimpleName(), e);
            throw new RuntimeException("Failed to parse XDM list response", e);
        }
    }
}