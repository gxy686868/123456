package com.example.cloudprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class SayHelloController {
    //读取配置文件中的配置
    @Value("${server.port}")
    private String port;
    @GetMapping("sayHello")
    public String SayHell(String name){
        return name+"欢迎访问"+port+"生产者";
    }
}
