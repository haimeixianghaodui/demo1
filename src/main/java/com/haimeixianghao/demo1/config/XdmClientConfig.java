package com.haimeixianghao.demo1.config;

import com.haimeixianghao.demo1.xdm.XdmClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(XdmProperties.class)
public class XdmClientConfig {

    @Bean
    public RestClient xdmRestClient(XdmProperties props) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(props.getTimeout().getConnectMs());
        factory.setReadTimeout(props.getTimeout().getReadMs());

        String baseUrl = props.getEndpoint() + props.resolvedBasePath();

        RestClient.Builder builder = RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(factory);

        // Add auth header based on type
        if ("token".equalsIgnoreCase(props.getAuth().getType())) {
            builder.defaultHeader("Authorization", "Bearer " + props.getAuth().getToken());
        }

        return builder.build();
    }

    @Bean
    public XdmClient xdmClient(RestClient xdmRestClient, XdmProperties props) {
        return new XdmClient(xdmRestClient, props);
    }
}
