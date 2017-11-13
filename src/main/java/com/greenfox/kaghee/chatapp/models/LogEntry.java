package com.greenfox.kaghee.chatapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String path;
    String method;
    String dateAndTime;
    String logLevel;
    String requestData;

    public LogEntry() {
    }

    public LogEntry(String path, String method, String logLevel, String requestData) {
        this.path = path;
        this.method = method;
        this.dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS"));
        this.logLevel = logLevel;
        this.requestData = requestData;
    }

    public LogEntry(String path, String method, String logLevel) {      // ha nincs semmi request param
        this.path = path;
        this.method = method;
        this.dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS"));
        this.logLevel = logLevel;
        this.requestData = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }
}
