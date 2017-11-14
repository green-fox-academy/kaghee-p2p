package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.models.Incoming;
import com.greenfox.kaghee.chatapp.models.Message;
import com.greenfox.kaghee.chatapp.models.Status;
import com.greenfox.kaghee.chatapp.repos.MessageRepo;
import com.greenfox.kaghee.chatapp.service.MessageHandler;
import com.greenfox.kaghee.chatapp.service.RequestHandler;
import com.greenfox.kaghee.chatapp.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    MessageHandler messageHandler;

    @PostMapping("/api/message/receive")
    @CrossOrigin("*")
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
