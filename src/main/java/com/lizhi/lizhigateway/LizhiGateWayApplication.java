package com.lizhi.lizhigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LizhiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LizhiGateWayApplication.class, args);
    }

}
