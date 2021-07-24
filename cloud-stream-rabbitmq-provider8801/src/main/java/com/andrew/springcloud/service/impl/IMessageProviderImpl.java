package com.andrew.springcloud.service.impl;

import com.andrew.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Author Andrew Yang
 * @ClassName IMessageProviderImpl
 * @Description 定义消息的推送管道
 * @Package com.andrew.springcloud.service.impl
 * @Create 2021-07-23 09:17
 */
@EnableBinding(Source.class)//指定信道channel和exchange绑定在一起
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("***********uuid:" + uuid);
        return null;
    }
}
