package com.sdjzu.knowledgequiz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    //    测试跨域
    @GetMapping("/hello")
    public String hello(){
        return "helo";
    }

}
