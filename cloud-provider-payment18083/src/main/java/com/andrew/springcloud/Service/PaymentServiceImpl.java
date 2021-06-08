package com.andrew.springcloud.Service;

import com.andrew.springcloud.dao.PaymentDao;
import com.andrew.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrew Yang
 * @className PaymentServiceImpl
 * @description
 * @package com.andrew.springcloud.Service
 * @create 2021-05-30 15:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment create(Payment payment){
        int i = paymentDao.create(payment);
        return payment;
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
