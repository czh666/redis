package com.example.demo.controller;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czh
 * @version 1.0
 * @date 2022/10/10 22:22
 */
@RestController
public class Hellocontroller {
    @RequestMapping("/hello")
    public String test(@RequestParam("name") String name){
        return "hello"+name;
    }
}
