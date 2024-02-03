package com.tananushka.javaadvance.module01.config.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = "custom.datasource.enable=false")
class DataSourceFallbackTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void shouldUseDefaultDataSource_whenCustomDataSourceIsDisabled() {
        assertThat(context.getBean(DataSource.class)).isNotNull();
    }
}
