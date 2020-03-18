package com.gqb.eureka.feign.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *@FeignClient 此处不写不可以，但是value没有实际作用，没被调用，类似bean的名字
 */
@FeignClient(value = "eureka-provide-user")
public interface UserInterface {
//    @PostMapping("/users")
//    MoRp<List<MoUser>> getUsers(MoRq rq);

    @GetMapping("/msg")
    String getMsg();
}
