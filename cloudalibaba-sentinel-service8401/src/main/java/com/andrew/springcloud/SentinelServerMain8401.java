package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Andrew Yang
 * @ClassName PaymentMain9001
 * @Description
 * @Package com.andrew.springcloud
 * @Create 2021-07-24 21:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServerMain8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServerMain8401.class, args);
    }
}