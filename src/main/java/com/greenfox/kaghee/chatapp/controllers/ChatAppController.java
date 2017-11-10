package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.models.LogEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatAppController {
    @RequestMapping(value="/")
    public String home(Model model) {
        List<LogEntry> list = new ArrayList<>();
        list.add(new LogEntry("/", "GET", "INFO"));
        list.add(new LogEntry("/", "GET", "INFO1"));
        list.add(new LogEntry("/", "GET", "INFO2"));
        model.addAttribute("list", list);
        return "home";
    }
}
