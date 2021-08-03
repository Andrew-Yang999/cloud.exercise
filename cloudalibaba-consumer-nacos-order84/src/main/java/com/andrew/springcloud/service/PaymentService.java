package com.andrew.springcloud.service;

import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Andrew Yang
 * @ClassName PaymentService
 * @Description
 * @Package com.andrew.springcloud.service
 * @Create 2021-07-28 22:01
 */
@FeignClient(value = "cloudalibaba-provider-payment", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
