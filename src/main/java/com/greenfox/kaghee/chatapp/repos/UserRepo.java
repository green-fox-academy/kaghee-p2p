package com.greenfox.kaghee.chatapp.repos;

import com.greenfox.kaghee.chatapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findUserByUserName(String userName);
    User findUserById(Long id);
}
