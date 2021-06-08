package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Andrew Yang
 * @className GatewayMain19527
 * @description
 * @package com.andrew.springcloud
 * @create 2021-06-07 18:31
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain19527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain19527.class, args);
    }
}
