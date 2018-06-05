package com.zhou.wise.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {

    @Value("${datasource.master.url}")
    private String url;

    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master") // application.properteis中对应属性的前缀
    public DataSource dataSourceMaster() {
        System.out.println("url:"+url);
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave") // application.properteis中对应属性的前缀
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().build();
    }


}
