package com.andrew.springcloud.Service;

import com.andrew.springcloud.entities.Payment;

/**
 * @Author Andrew Yang
 * @ClassName PaymentService
 * @Description
 * @Package com.andrew.springcloud.Service
 * @create 2021-05-30 15:11
 */
public interface PaymentService {
    Payment create(Payment payment);

    Payment getPaymentById(Long id);
}
