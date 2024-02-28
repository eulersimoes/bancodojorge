package br.com.bancodojorge.apirest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class GraphQLConfig {

    private static Logger logger = LoggerFactory.getLogger("GraphQLConfig.class");

    @Bean
    public GraphQlSourceBuilderCustomizer sourceBuilderCustomizer() {
        return (builder) ->
                builder.inspectSchemaMappings(report -> {
                    logger.debug(report.toString());
                });
    }
}
