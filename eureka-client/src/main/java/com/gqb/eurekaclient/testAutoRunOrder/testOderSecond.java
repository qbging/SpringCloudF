package com.gqb.eurekaclient.testAutoRunOrder;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author guoqb
 * @date : 2019/10/23 9:49
 * @descript
 */
@Component
@Order(2)// 如果有多个类实现了ApplicationRunner接口,可以使用此注解指定执行顺序
public class testOderSecond implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("second....."+args);
    }
}
