package com.gqb.api.rabbit.sender;

import com.gqb.eureka.feign.inter.RabbitMQInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqb
 * @date : 2019/11/13 22:37
 * @descript
 */
@RestController
@RequestMapping("/mq")
public class ControllerTest implements RabbitMQInterface {

    @Autowired
    HelloSender helloSender;

    @GetMapping("/test")
    public String send(){
        helloSender.send(null);
        return "success";
    }

    @Override
    public String getMsg() {
        String msg = "生产者线程："+Thread.currentThread().getName() + "+ 你发送成功了";
//        helloSender.send(msg);//默认交换机（）
//        helloSender.sendDirectMessage(msg);//直连交换机
        helloSender.sendTopicMessage(msg);//Topic
//        helloSender.sendFanoutMessage(msg);//fanout
        return msg;
    }
}
