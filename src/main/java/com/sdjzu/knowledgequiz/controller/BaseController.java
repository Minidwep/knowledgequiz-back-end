package com.sdjzu.knowledgequiz.controller;

import com.sdjzu.knowledgequiz.util.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@RestController
@Slf4j
public class BaseController {

    @GetMapping("toLogin")
    public String toLogin(){
        return "请登录";
    }

    @GetMapping("/index")
    public Msg toIndex(){
        return Msg.success();
    }
}
