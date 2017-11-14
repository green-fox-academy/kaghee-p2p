package com.greenfox.kaghee.chatapp.models;

import javax.persistence.Id;

public class Incoming {
    Message message;
    Client client;

    public Incoming() {
    }

    public Incoming(Message message, Client client) {
        this.message = message;
        this.client = client;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
