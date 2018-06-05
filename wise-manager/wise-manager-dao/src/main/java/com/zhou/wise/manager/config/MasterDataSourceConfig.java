package com.zhou.wise.manager.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
//@MapperScan(basePackages = "com.zhou.wise", sqlSessionTemplateRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

//    @Bean(name = "masterTransactionManager")
//    @Primary
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager();
//    }
//
//    @Bean(name = "masterSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory setSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/base/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "masterSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
