package com.zhou.wise.manager.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDubboConfiguration
@EnableAutoConfiguration //(exclude={DataSourceAutoConfiguration.class})
public class WiseManagerWebApplication {

    public static void main(String[] args) {
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.setProperty("dubbo.qos.port", "33333");

        SpringApplication.run(WiseManagerWebApplication.class, args);
    }
}
