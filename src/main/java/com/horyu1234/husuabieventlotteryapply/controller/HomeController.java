package com.horyu1234.husuabieventlotteryapply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by horyu on 2018-04-02
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "redirect:/apply";
    }
}
