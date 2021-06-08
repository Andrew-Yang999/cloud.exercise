package com.andrew.springcloud;

import com.andrew.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Andrew Yang
 * @className OrderApplicationMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 16:00
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationMain.class, args);
    }
}
