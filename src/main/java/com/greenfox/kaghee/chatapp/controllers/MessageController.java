//package com.greenfox.kaghee.chatapp.controllers;
//
//import com.greenfox.kaghee.chatapp.models.Message;
//import com.greenfox.kaghee.chatapp.repos.MessageRepo;
//import com.greenfox.kaghee.chatapp.service.MessageHandler;
//import com.greenfox.kaghee.chatapp.service.UserHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
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
//    @GetMapping("/writemessage")
//    public void writeMessage(@RequestParam(value = "message") String message) {
//        Message msg = new Message(userHandler.getCurrentUser().getUsername(), message);
//        messageHandler.addMessage(msg);
//
//
//    }
//
//
//}
