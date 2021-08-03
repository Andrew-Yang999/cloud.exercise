package com.andrew.springcloud.controller;

import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import com.andrew.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author Andrew Yang
 * @className OrderController
 * @description
 * @package com.andrew.springcloud.controller
 * @create 2021-05-30 16:02
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;

    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ParameterizedTypeReference<CommonResult<Payment>> reference = new ParameterizedTypeReference<CommonResult<Payment>>() {
        };
        ResponseEntity<CommonResult<Payment>> forEntity = restTemplate.exchange(PAYMENT_URL + "/payment/get/" + id, HttpMethod.GET, null, reference);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }
        return new CommonResult<>(500, "操作失败");
    }

    @PostMapping(value = "/getForEntity/create")
    public CommonResult<Payment> create2(@RequestBody Payment payment) {
        ParameterizedTypeReference<CommonResult<Payment>> reference = new ParameterizedTypeReference<CommonResult<Payment>>() {
        };
        HttpEntity<Payment> paymentHttpEntity = new HttpEntity<>(payment);
        ResponseEntity<CommonResult<Payment>> exchange = restTemplate.exchange(PAYMENT_URL + "/payment/create", HttpMethod.POST, paymentHttpEntity, reference);
        if (exchange.getStatusCode().is2xxSuccessful()) {
            return exchange.getBody();
        }
        return new CommonResult<>(500, "操作失败");
    }


    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (null == instances || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return "hi, I'm consumerZipkin server fall back, welcome to andrew.";
    }
}
