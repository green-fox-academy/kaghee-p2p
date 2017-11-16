package com.greenfox.kaghee.chatapp.service;

import com.greenfox.kaghee.chatapp.models.User;
import com.greenfox.kaghee.chatapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {
    User currentUser;

    @Autowired
    UserRepo userRepo;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getUserByName(String name) {
        return userRepo.findUserByUserName(name);
    }

    public User getUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public void saveUser(String username) {
        userRepo.save(new User(username));
        currentUser = getUserByName(username);
    }

}
