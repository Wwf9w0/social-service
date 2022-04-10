package com.social.user.service.configuration;

import com.social.user.service.configuration.properties.ElasticSearchProperties;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ElasticSearchConfiguration {
    private final ElasticSearchProperties elasticsearchProperties;

    @Bean
    public RestHighLevelClient client(){
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(elasticsearchProperties.getUsername(),
                        elasticsearchProperties.getPassword()));
        HttpHost httpHost = new HttpHost(elasticsearchProperties.getHost(),
                elasticsearchProperties.getPort(),
                elasticsearchProperties.getScheme());
        RestClientBuilder builder = RestClient
                .builder(httpHost)
                .setHttpClientConfigCallback(httpAsyncClientBuilder ->
                        httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        return new RestHighLevelClient(builder);
    }
}
