package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Andrew Yang
 * @className EurekaApplicationMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 17:14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationMain.class);
    }
}
