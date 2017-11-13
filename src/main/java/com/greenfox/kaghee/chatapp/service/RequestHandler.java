package com.greenfox.kaghee.chatapp.service;

import com.greenfox.kaghee.chatapp.models.LogEntry;
import com.greenfox.kaghee.chatapp.repos.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RequestHandler {

    @Autowired
    LogRepo logRepo;

    public void printLog(HttpServletRequest request) {
        if (checkIfInfo()) {
            LogEntry log = new LogEntry(request);
            logRepo.save(log);
            System.out.println(log);
        }
    }

    public void printError(HttpServletRequest request) {
        LogEntry log = new LogEntry(request);
        log.setLogLevel("ERROR");
        logRepo.save(log);
        System.err.println(log);
    }

    public boolean checkIfInfo() {
        return System.getenv("CHAT_APP_LOGLEVEL").equals("INFO");
    }
}
