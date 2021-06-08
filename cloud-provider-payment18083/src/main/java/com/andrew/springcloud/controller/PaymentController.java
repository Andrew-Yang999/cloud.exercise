package com.andrew.springcloud.controller;

import com.andrew.springcloud.Service.PaymentService;
import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Andrew Yang
 * @className PaymentController
 * @description
 * @package com.andrew.springcloud.controller
 * @create 2021-05-30 15:14
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        CommonResult<Payment> commonResult = new CommonResult<>(500, "插入失败,serverPort:" + serverPort);
        Payment resultPayment = paymentService.create(payment);
        if (null != resultPayment) {
            return new CommonResult<Payment>(200, "插入成功,serverPort:" + serverPort, resultPayment);
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

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
