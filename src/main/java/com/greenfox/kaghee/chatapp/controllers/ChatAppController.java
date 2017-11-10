package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.models.LogEntry;
import com.greenfox.kaghee.chatapp.repos.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatAppController {
    @Autowired
    LogRepo logRepo;

    @RequestMapping(value="/")
    public String home(HttpServletRequest request, Model model) {
        List<LogEntry> list = new ArrayList<>();
        logRepo.save(new LogEntry(request.getRequestURI(), request.getMethod(), "INFO", request.getQueryString()));
        for (LogEntry entry : logRepo.findAll()) {
            list.add(entry);
        }
        model.addAttribute("list", list);
        return "home";
    }
}
