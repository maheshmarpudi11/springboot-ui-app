package com.example.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, produces = "text/html")
    public String home() {
        return "home";
    }
}
