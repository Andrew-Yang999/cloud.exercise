package com.andrew.springcloud.service;

import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author Andrew Yang
 * @ClassName PaymentFallbackServiceImpl
 * @Description
 * @Package com.andrew.springcloud.service
 * @Create 2021-07-28 22:04
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(4444,"服务降级返回，----paymentFallbackService",new Payment(id,"errorSerial"));
    }
}
