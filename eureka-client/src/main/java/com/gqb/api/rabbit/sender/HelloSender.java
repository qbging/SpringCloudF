package com.gqb.api.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * rabbit 发送端
 */
@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String context) {
		if (StringUtils.isEmpty(context)){
			context = "hello " + new Date();
		}
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}

	public void sendDirectMessage(String context) {
		if (StringUtils.isEmpty(context)){
			context = "hello " + new Date();
		}
		System.out.println("Sender DirectMessage : " + context);
		this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE,RabbitConfig.DIRECT_ROUTING_KEY,context);
	}

	public void sendTopicMessage(String context){
		if (StringUtils.isEmpty(context)){
			context = "hello " + new Date();
		}
		System.out.println("Sender TopicMessage : " + context);
//		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE,"lzc.1234",context);//两个queue匹配
		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE,"lzc.asdsg",context);//只有queue2，key是"lzc.#"匹配
	}

	public void sendFanoutMessage(String context){
		if (StringUtils.isEmpty(context)){
			context = "hello " + new Date();
		}
		System.out.println("Sender FanoutMessage : " + context);
		this.rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"lzc.asdsg",context);//此时第二个参数routingkey会被忽略
	}

}