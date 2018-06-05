package com.zhou.wise.manager.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.inject.Qualifier;
import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = "com.zhou.wise", sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class SlaveDataSourceConfig {

//
//    @Bean(name = "slaveTransactionManager")
//    @Primary
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("slaveDataSource") DataSource slaveDataSource) {
//        return new DataSourceTransactionManager();
//    }
//
//    @Bean(name = "slaveSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory setSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(slaveDataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/base/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "slaveSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory slaveSqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(slaveSqlSessionFactory);
//    }
}
