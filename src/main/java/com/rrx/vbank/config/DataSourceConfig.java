package com.rrx.vbank.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Administrator
 */
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.vbankds") // application.properteis中对应属性的前缀
    public DataSourceProperties vbankDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "vbankds")
    @ConfigurationProperties("spring.datasource.vbankds")
    public DataSource tmanagerSource(){
        return vbankDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
