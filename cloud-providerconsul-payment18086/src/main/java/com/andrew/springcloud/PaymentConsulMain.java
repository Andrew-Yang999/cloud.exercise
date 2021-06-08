package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Andrew Yang
 * @className PaymentConsulMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-06-02 15:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain.class, args);
    }
}
