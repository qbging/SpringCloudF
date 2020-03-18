package com.gqb.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class MsgController {

    @Autowired
    private HttpServletRequest request;

//    @Autowired
//    DiscoveryClient client;

    @GetMapping(value="/getmsg")
    public String getMsg(){
        return "这里是client，servletPath："+request.getServletPath()+"，requestUrl: "
                +request.getRequestURL()+",requestUri:"+request.getRequestURI();
    }
}
