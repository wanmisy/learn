package com.example.concurrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MainController
 * @Description TODO
 * @Author missj
 * @Date 2018/12/11 12:55
 * @Version 1.0
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
