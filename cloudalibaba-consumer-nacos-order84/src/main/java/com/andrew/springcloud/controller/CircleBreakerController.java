package com.andrew.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.andrew.springcloud.entities.CommonResult;
import com.andrew.springcloud.entities.Payment;
import com.andrew.springcloud.service.PaymentService;
import com.sun.deploy.security.BlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Andrew Yang
 * @ClassName CircleBreakerController
 * @Description
 * @Package com.andrew.springcloud.controller
 * @Create 2021-07-28 09:30
 */
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://cloudalibaba-provider-payment";

    @Resource
    private PaymentService paymentService;
    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockedHandler",exceptionsToIgnore =IllegalArgumentException.class )
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常handlerFallback,exception内容" + e.getMessage(), payment);
    }

    public CommonResult<Payment> blockedHandler(@PathVariable Long id, BlockedException blockedException) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "blockedHandler-sentinel限流,无此流水：blockedException" + blockedException.getMessage(), payment);
    }

    @RequestMapping("/consumer/paymentSql/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockedHandler",exceptionsToIgnore =IllegalArgumentException.class )
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }
}
