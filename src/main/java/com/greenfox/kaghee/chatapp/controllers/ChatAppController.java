package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.models.LogEntry;
import com.greenfox.kaghee.chatapp.models.User;
import com.greenfox.kaghee.chatapp.repos.LogRepo;
import com.greenfox.kaghee.chatapp.repos.UserRepo;
import com.greenfox.kaghee.chatapp.service.RequestHandler;
import com.greenfox.kaghee.chatapp.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatAppController {
    @Autowired
    LogRepo logRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RequestHandler requestHandler;

    @Autowired
    UserHandler userHandler;

    @RequestMapping(value="/")
    public String home(HttpServletRequest request, Model model) {
        requestHandler.printLog(request);
        if (userHandler.getCurrentUser() == null) {
            return "enter";
        } else {
            model.addAttribute("currentUser", userHandler.getCurrentUser());
            return "home";
        }

    }

    @GetMapping("/enter")
    public String enter() {
        return "enter";
    }

    @GetMapping("/enter/adduser")
    public String addUser(HttpServletRequest request, @RequestParam(value = "userName") String username) {
        userRepo.save(new User(username));
        userHandler.setCurrentUser(userHandler.findUser(username));
        return "redirect:/";
    }
}
