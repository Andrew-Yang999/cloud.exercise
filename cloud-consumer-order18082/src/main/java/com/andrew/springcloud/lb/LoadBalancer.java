package com.andrew.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Andrew Yang
 * @ClassName LoadBalancer
 * @Description
 * @Package com.andrew.springcloud.lb
 * @create 2021-06-03 10:16
 */
public interface LoadBalancer {
    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
