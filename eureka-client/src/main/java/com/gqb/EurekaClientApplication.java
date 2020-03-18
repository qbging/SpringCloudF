package com.gqb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此处设置了@MapperScan注解,因此dao文件中不需要添加@Mapper注解
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gqb.eurekaclient.dao")
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}
