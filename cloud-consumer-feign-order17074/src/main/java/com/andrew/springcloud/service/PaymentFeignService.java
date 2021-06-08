package com.andrew.springcloud.service;

import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.GET;
import java.util.concurrent.TimeUnit;

/**
 * @Author Andrew Yang
 * @ClassName PaymentFeignService
 * @Description
 * @Package com.andrew.springcloud.service
 * @create 2021-06-03 11:56
 */
@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
