package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.models.Client;
import com.greenfox.kaghee.chatapp.models.Incoming;
import com.greenfox.kaghee.chatapp.models.Message;
import com.greenfox.kaghee.chatapp.models.Status;
import com.greenfox.kaghee.chatapp.service.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MessageController {
    @Autowired
    MessageHandler messageHandler;

    @PostMapping("/api/message/receive")
    @CrossOrigin("*")
    public Status receiveMessage(@RequestBody Incoming incoming) {
        if (incoming.getMessage().getTimestamp() == null || incoming.getMessage().getText() == null ||
                incoming.getMessage().getUsername() == null) {
            return new Status("error","Missing field(s)");
        } else {
            messageHandler.addMessage(incoming.getMessage());
            return new Status("ok");
        }
    }
}
