package com.greenfox.kaghee.chatapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatAppController {

    @GetMapping(value="/")
    public String home() {
        return "home";
    }
}
