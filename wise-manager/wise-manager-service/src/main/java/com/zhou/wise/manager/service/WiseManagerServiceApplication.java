package com.zhou.wise.manager.service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.zhou.wise")
@SpringBootApplication(scanBasePackages = "com.zhou.wise")
@EnableDubboConfiguration
public class WiseManagerServiceApplication {


    private static final Logger logger = LoggerFactory.getLogger(WiseManagerServiceApplication.class);

    public static void main(String[] args) {
        logger.info("### DubboProviderApplication starter ...");
        SpringApplication.run(WiseManagerServiceApplication.class, args);
    }
}
