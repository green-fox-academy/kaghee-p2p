//package com.greenfox.kaghee.chatapp.controllers;
//
//import com.greenfox.kaghee.chatapp.models.Message;
//import com.greenfox.kaghee.chatapp.repos.MessageRepo;
//import com.greenfox.kaghee.chatapp.service.MessageHandler;
//import com.greenfox.kaghee.chatapp.service.RequestHandler;
//import com.greenfox.kaghee.chatapp.service.UserHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//public class MessageController {
//    @Autowired
//    MessageRepo messageRepo;
//
//    @Autowired
//    MessageHandler messageHandler;
//
//    @Autowired
//    UserHandler userHandler;
//
//    @Autowired
//    RequestHandler requestHandler;
//
//    @GetMapping("/writemessage")
//    public String writeMessage(@RequestParam(value = "text") String text, HttpServletRequest request) {
//        messageHandler.addMessage(new Message(userHandler.getCurrentUser().getUsername(), text));
//        requestHandler.printLog(request);
//        return "home";
//    }
//
//
//}
