package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Andrew Yang
 * @className PaymentApplicationMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 14:15
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationMain.class, args);
    }
}
