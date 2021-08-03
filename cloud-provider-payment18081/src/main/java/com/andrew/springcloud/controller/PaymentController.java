package com.andrew.springcloud.controller;

import com.andrew.springcloud.Service.PaymentService;
import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Andrew Yang
 * @className PaymentController
 * @description
 * @package com.andrew.springcloud.controller
 * @create 2021-05-30 15:14
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        CommonResult<Payment> commonResult = new CommonResult<>(500, "插入失败,serverPort:" + serverPort);
        Payment resultPayment = paymentService.create(payment);
        if (null != resultPayment) {
            return new CommonResult<Payment>(200, "插入成功,serverPort:" + serverPort,resultPayment);
        }
        return commonResult;
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = new CommonResult<>(500, "查询失败,serverPort:" + serverPort);
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult<Payment>(200, "查询成功,serverPort:" + serverPort, payment);
        }
        return commonResult;
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi, I'm paymentZipkin server fall back, welcome to andrew.";
    }
}
