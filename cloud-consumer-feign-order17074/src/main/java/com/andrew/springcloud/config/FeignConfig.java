package com.andrew.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Andrew Yang
 * @className FeignConfig
 * @description
 * @package com.andrew.springcloud.config
 * @create 2021-06-04 10:24
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
