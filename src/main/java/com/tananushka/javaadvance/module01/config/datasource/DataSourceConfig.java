package com.tananushka.javaadvance.module01.config.datasource;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
@Slf4j
public class DataSourceConfig {

    private final DataSourceProperties dataSourceProperties;

    @Bean
    @ConditionalOnProperty(name = "custom.datasource.enable", havingValue = "true", matchIfMissing = true)
    public DataSource dataSource() {
        log.debug("\n\n>>>>> Creating custom data source <<<<<\n");
        return DataSourceBuilder.create()
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .driverClassName(dataSourceProperties.getDriverClassName())
                .build();
    }
}
