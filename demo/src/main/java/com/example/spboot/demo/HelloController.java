package com.example.spboot.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController(value = "/")//request mapping路径
public class HelloController {

    @RequestMapping(path = "login",method = GET) //path 定义映射的子路径
    public String index(){
        return "test";
    }
}
