package com.gqb.eurekaconsumer.service;

import com.gqb.eureka.feign.inter.UserInterface;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient("eureka-provider/user")
public interface UserService extends UserInterface {
}
