package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czh
 * @version 1.0
 * @date 2022/10/11 10:21
 */
@RestController
public class Hello1controller {
    @RequestMapping("/hello1")
    public String test(@RequestParam("name") String name,@RequestParam("age") String age){
        return "hello"+name+" "+age;
    }
    @RequestMapping("/hello2")
    public String test2(@RequestParam("name") String name,@RequestParam("age") String age){
        return "hello"+name+" "+age;
    }
}
