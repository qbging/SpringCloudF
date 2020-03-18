package com.gqb.eurekaconsumer.service;

import com.gqb.eureka.feign.inter.RabbitMQInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-provider/mq")
public interface RabbitService extends RabbitMQInterface {
}
