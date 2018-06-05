package com.zhou.wise.manager.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {

    @Value("${datasource.master.url}")
    private String masterUrl;

    @Value("${datasource.master.name}")
    private String masterName;

    @Value("${datasource.master.username}")
    private String masterUserName;

    @Value("${datasource.master.password}")
    private String masterPassword;

    @Value("${datasource.master.filters}")
    private String masterFilters;

    @Value("${datasource.master.connectionProperties}")
    private String masterConnectionProperties;


    @Value("${datasource.slave.name}")
    private String slaveName;

    @Value("${datasource.slave.url}")
    private String slaveUrl;

    @Value("${datasource.slave.username}")
    private String slaveUserName;

    @Value("${datasource.slave.password}")
    private String slavePassword;


    @Value("${datasource.slave.filters}")
    private String slaveFilters;

    @Value("${datasource.slave.connectionProperties}")
    private String slaveConnectionProperties;


    @Primary
    @Bean(name = "masterDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.master") // application.properteis中对应属性的前缀
    public DataSource dataSourceMaster() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(masterUserName);
        druidDataSource.setPassword(masterPassword);
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl(masterUrl);
        druidDataSource.setMaxActive(100);
        druidDataSource.setInitialSize(10);
        try {
            druidDataSource.setFilters(masterFilters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        druidDataSource.setConnectionProperties(masterConnectionProperties);
        return druidDataSource;
    }


    @Bean(name = "slaveDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.slave") // application.properteis中对应属性的前缀
    public DataSource dataSourceSlave() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(slaveUserName);
        druidDataSource.setPassword(slavePassword);
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl(slaveUrl);
        druidDataSource.setMaxActive(100);
        druidDataSource.setInitialSize(10);
        try {
            druidDataSource.setFilters(slaveFilters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        druidDataSource.setConnectionProperties(slaveConnectionProperties);
        return druidDataSource;
    }


    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "luoyizhou");
        servletRegistrationBean.addInitParameter("loginPassword", "luoyizhou");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
