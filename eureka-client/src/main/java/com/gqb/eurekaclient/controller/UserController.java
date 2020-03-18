package com.gqb.eurekaclient.controller;

import com.gqb.eureka.feign.inter.UserInterface;
import com.gqb.eurekaclient.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController implements UserInterface {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public String getMsg() {
        return "这里是client，servletPath："+request.getServletPath()+"，当前请求requestUrl: "
                +request.getRequestURL()+",requestUri:"+request.getRequestURI();
    }

    @GetMapping("/{id}")
    public Object getObject(@PathVariable String id){
        Object o = userService.queryObjectByid(id);
        return o;
    }
}
