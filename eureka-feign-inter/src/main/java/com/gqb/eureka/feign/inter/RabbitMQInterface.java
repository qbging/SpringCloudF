package com.gqb.eureka.feign.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provide-mq")
public interface RabbitMQInterface {

    @GetMapping("/testMq")
    String getMsg();
}
