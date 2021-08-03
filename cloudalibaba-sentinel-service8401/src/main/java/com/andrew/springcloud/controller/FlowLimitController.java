package com.andrew.springcloud.controller;

import java.util.concurrent.TimeUnit;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author Andrew Yang
 * @ClassName PaymentController
 * @Description
 * @Package com.andrew.springcloud.controller
 * @Create 2021-07-24 21:27
 */
@RestController
public class FlowLimitController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/testA")
    public String testA() {
        System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" + "....testB");
        return "----------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "----------testB";
    }

    @GetMapping(value = "/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" +"测试testD");
        return "----------testD";
    }
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String  tastHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
    ) {
        int age = 10 / 0;
        System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" +"testHotKey");
        return "--------------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" +"deal_testHotKey");
        return "--------------deal_testHotKey";
    }
}