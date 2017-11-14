package com.greenfox.kaghee.chatapp.service;

import com.greenfox.kaghee.chatapp.models.Message;
import com.greenfox.kaghee.chatapp.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageHandler {
    @Autowired
    MessageRepo messageRepo;

    public void addMessage(Message msg) {
        messageRepo.save(msg);
    }
    
    public Iterable<Message> listMessages() {
        return messageRepo.findAll();
    }
}
