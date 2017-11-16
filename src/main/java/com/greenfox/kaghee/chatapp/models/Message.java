package com.greenfox.kaghee.chatapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    long id;
    String username;
    String text;
    Timestamp timestamp;

    public Message(String username, String text) {
        this.id = (int)(Math.random() * 9999999 + 1000000);
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.username = username;
        this.text = text;
    }

    public Message() {
        this.id = (int)(Math.random() * 9999999 + 1000000);
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
