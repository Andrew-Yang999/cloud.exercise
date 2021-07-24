package com.andrew.springcloud.controller;

import com.andrew.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Andrew Yang
 * @ClassName SendMessageController
 * @Description
 * @Package com.andrew.springcloud.controller
 * @Create 2021-07-23 09:30
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
