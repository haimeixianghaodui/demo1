package com.haimeixianghao.demo1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "idma")
public class XdmProperties {
    private boolean enabled = false;
    private String endpoint = "";
    private String applicationId = "";
    private String basePath = "/rdm_{applicationId}_app/services/dynamic/api";
    private final Timeout timeout = new Timeout();
    private final Retry retry = new Retry();
    private final Auth auth = new Auth();

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public String getEndpoint() { return endpoint; }
    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }
    public String getApplicationId() { return applicationId; }
    public void setApplicationId(String applicationId) { this.applicationId = applicationId; }
    public String getBasePath() { return basePath; }
    public void setBasePath(String basePath) { this.basePath = basePath; }
    public Timeout getTimeout() { return timeout; }
    public Retry getRetry() { return retry; }
    public Auth getAuth() { return auth; }

    public String resolvedBasePath() {
        return basePath.replace("{applicationId}", applicationId);
    }

    public static class Timeout {
        private int connectMs = 5000;
        private int readMs = 10000;
        public int getConnectMs() { return connectMs; }
        public void setConnectMs(int connectMs) { this.connectMs = connectMs; }
        public int getReadMs() { return readMs; }
        public void setReadMs(int readMs) { this.readMs = readMs; }
    }

    public static class Retry {
        private int maxAttempts = 3;
        private int backoffMs = 200;
        public int getMaxAttempts() { return maxAttempts; }
        public void setMaxAttempts(int maxAttempts) { this.maxAttempts = maxAttempts; }
        public int getBackoffMs() { return backoffMs; }
        public void setBackoffMs(int backoffMs) { this.backoffMs = backoffMs; }
    }

    public static class Auth {
        private String type = "";
        private String ak = "";
        private String sk = "";
        private String token = "";
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public String getAk() { return ak; }
        public void setAk(String ak) { this.ak = ak; }
        public String getSk() { return sk; }
        public void setSk(String sk) { this.sk = sk; }
        public String getToken() { return token; }
        public void setToken(String token) { this.token = token; }
    }
}
