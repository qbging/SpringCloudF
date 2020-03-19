package com.gqb.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author guoqb
 * @date : 2020/3/19 11:24
 * @descript
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class EurekaZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulApplication.class, args);
    }
}
