package com.greenfox.kaghee.chatapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    long id;
    String userName;
    String text;
    Timestamp createdAt;

    public Message(String userName, String text) {
        this.id = (int)(Math.random() * 9999999 + 1000000);
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.userName = userName;
        this.text = text;
    }

    public Message() {
        this.id = (int)(Math.random() * 9999999 + 1000000);
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
