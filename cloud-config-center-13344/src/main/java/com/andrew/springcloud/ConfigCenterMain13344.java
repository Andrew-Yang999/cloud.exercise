package com.andrew.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Andrew Yang
 * @className ConfigCenterMain13344
 * @description
 * @package com.andrew.springcloud
 * @create 2021-06-09 15:12
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigCenterMain13344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain13344.class, args);
    }
}
