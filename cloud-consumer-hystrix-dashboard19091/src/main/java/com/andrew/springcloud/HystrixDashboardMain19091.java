package com.andrew.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author zzyy
 * @create 2020/3/7 17:27
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain19091 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain19091.class);
    }
}


