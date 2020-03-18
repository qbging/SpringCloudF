package com.gqb.api.rabbit.sender;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    //topic
    public static final String TOPIC_QUEUE1 = "rabbit-topic.queue1";
    public static final String TOPIC_QUEUE2 = "rabbit-topic.queue2";
    public static final String TOPIC_EXCHANGE = "rabbit-topic.exchange";
    public static final String TOPIC_ROUTING_KEY1 = "lzc.123";
    public static final String TOPIC_ROUTING_KEY2 = "lzc.#";

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_ROUTING_KEY1);
    }
    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_ROUTING_KEY2);
    }

    //fanout
    public static final String FANOUT_QUEUE1 = "rabbit-fanout.queue1";
    public static final String FANOUT_QUEUE2 = "rabbit-fanout.queue2";
    public static final String FANOUT_EXCHANGE = "rabbit-fanout.exchange";
    /**
     * Fanout模式
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE1);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
    //redirect模式
    public static final String DIRECT_QUEUE1 = "rabbit-direct.queue1";
//    public static final String DIRECT_QUEUE2 = "rabbit-direct.queue2";
    public static final String DIRECT_EXCHANGE = "rabbit-direct.exchange";
    public static final String DIRECT_ROUTING_KEY = "direct.pwl";
    /**
     * direct模式
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
     *
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE1);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(DIRECT_ROUTING_KEY);
    }
}