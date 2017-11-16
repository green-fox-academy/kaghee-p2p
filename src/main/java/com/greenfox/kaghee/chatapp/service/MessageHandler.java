package com.greenfox.kaghee.chatapp.service;

import com.greenfox.kaghee.chatapp.models.Client;
import com.greenfox.kaghee.chatapp.models.Incoming;
import com.greenfox.kaghee.chatapp.models.Message;
import com.greenfox.kaghee.chatapp.models.Status;
import com.greenfox.kaghee.chatapp.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public void sendMessage(Incoming incoming) {
        RestTemplate template = new RestTemplate();
        HttpEntity<Incoming> entity = new HttpEntity<>(incoming);
        Status response = template.postForObject(System.getenv("CHAT_APP_PEER_ADDRESS"), entity, Status.class);
    }
}
