package com.gqb.api.rabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * rabbit 接收端
 */
@Component
public class HelloReceiver {

//    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

//    @RabbitHandler
    @RabbitListener(queues = {DirectRabbitConfig.DIRECT_QUEUE1})
    public void processDirectMessage(String hello) {
        System.out.println("消费者 Receiver DirectMessage : " + hello);
    }

    @RabbitListener(queues = {TopicRabbitConfig.TOPIC_QUEUE1})
    public void processTopicMessage(String hello) {
        System.out.println("消费者 topic1 Receiver TopicMessage : " + hello);
    }
    @RabbitListener(queues = {TopicRabbitConfig.TOPIC_QUEUE2})
    public void processTopicMessage2(String hello) {
        System.out.println("消费者 topic2 Receiver TopicMessage : " + hello);
    }
    @RabbitListener(queues = {FanoutRabbitConfig.FANOUT_QUEUE1})
    public void processfanoutMessage1(String hello) {
        System.out.println("消费者线程  Receiver 1fanoutMessage : " + hello);
    }
    @RabbitListener(queues = {FanoutRabbitConfig.FANOUT_QUEUE2})
    public void processfanoutMessage2(String hello) {
        System.out.println("消费者线程  Receiver 2fanoutMessage : " + hello);
    }

}