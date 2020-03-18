package com.gqb.eurekaconsumer.controller;

import com.gqb.eurekaconsumer.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqb
 * @date : 2019/11/28 11:25
 * @descript
 */
@RestController
@RequestMapping("/consRbMQ")
public class RabbitController {
    @Autowired
    RabbitService service;

    @GetMapping("/testMq")
    public String getMqMsg(){
        String msg = service.getMsg();
        return "消费者线程:"+Thread.currentThread().getName()+"获取到消息："+msg;
    }
}
