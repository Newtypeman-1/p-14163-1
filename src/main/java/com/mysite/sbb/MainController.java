package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "<span style='color:red;'>index</span>";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello!";
    }
}
