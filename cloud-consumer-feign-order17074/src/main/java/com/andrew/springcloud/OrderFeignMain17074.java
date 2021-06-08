package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Andrew Yang
 * @className main
 * @description
 * @package com.andrew.springcloud
 * @create 2021-06-03 11:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderFeignMain17074 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain17074.class, args);
    }
}
