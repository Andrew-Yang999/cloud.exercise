package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Andrew Yang
 * @className OrderZkMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 14:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain.class, args);
    }
}
