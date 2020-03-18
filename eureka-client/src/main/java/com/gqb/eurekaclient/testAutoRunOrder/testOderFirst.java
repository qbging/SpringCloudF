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
@Order(1)
public class testOderFirst implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("first....."+args);
    }
}
