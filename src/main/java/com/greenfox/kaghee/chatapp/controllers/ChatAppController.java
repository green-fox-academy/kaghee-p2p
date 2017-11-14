package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.models.Incoming;
import com.greenfox.kaghee.chatapp.models.Message;
import com.greenfox.kaghee.chatapp.models.Status;
import com.greenfox.kaghee.chatapp.models.User;
import com.greenfox.kaghee.chatapp.repos.LogRepo;
import com.greenfox.kaghee.chatapp.repos.MessageRepo;
import com.greenfox.kaghee.chatapp.repos.UserRepo;
import com.greenfox.kaghee.chatapp.service.MessageHandler;
import com.greenfox.kaghee.chatapp.service.RequestHandler;
import com.greenfox.kaghee.chatapp.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class ChatAppController {
//    private static final Logger lgr = Logger.getLogger(ChatAppController.class.getName());

    @Autowired
    LogRepo logRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    RequestHandler requestHandler;

    @Autowired
    UserHandler userHandler;

    @Autowired
    MessageHandler messageHandler;

    @RequestMapping(value="/")
    public String home(HttpServletRequest request, Model model) {
        requestHandler.printLog(request);
        if (userHandler.getCurrentUser() == null) {
            return "enter";
        } else {
            model.addAttribute("currentUser", userHandler.getCurrentUser());
            model.addAttribute("messages", messageHandler.listMessages());
            return "home";
        }
    }

    @GetMapping("/enter/adduser")
    public String addUser(HttpServletRequest request, @RequestParam(value = "userName") String username, Model model) {
        String warning = "";
        model.addAttribute("name", username);
        if (username.equals("")) {
            warning = "The username field is empty!";
            model.addAttribute("noUser", warning);
            requestHandler.printError(request);
            return "enter";
        } else if (userRepo.findUserByUsername(username) != null) {
            warning = "This username already exists in the database.";
            model.addAttribute("noUser", warning);
            requestHandler.printError(request);
            return "enter";
        } else {
            userHandler.saveUser(username);
            userHandler.setCurrentUser(userHandler.getUserByName(username));
            requestHandler.printLog(request);
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable(value = "id") Long id, @RequestParam(value = "userName") String username,
                             HttpServletRequest request, Model model) {
        requestHandler.printLog(request);
        userHandler.getCurrentUser().setUsername(username);
        userRepo.save(userHandler.getCurrentUser());
        model.addAttribute("currentUser", userHandler.getCurrentUser());
        return "home";
    }

    @GetMapping("/writemessage")
    public String writeMessage(@RequestParam(value = "text") String text, HttpServletRequest request) {
        messageHandler.addMessage(new Message(userHandler.getCurrentUser().getUsername(), text));
        requestHandler.printLog(request);
        return "redirect:/";
    }

    @PostMapping("/api/message/receive")
    public Status receiveMessage(@RequestBody Incoming incoming) {
        //if any of the fields are missing, throw a 401, otherwise add msg to database
        if (incoming.getMessage().getCreatedAt() == null || incoming.getMessage().getText() == null ||
                incoming.getMessage().getUserName() == null) {
            return new Status("error","Missing field(s)");
        } else {
            messageHandler.addMessage(incoming.getMessage());
            return new Status("ok");
        }
    }
}
