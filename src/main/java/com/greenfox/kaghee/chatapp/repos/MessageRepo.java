package com.greenfox.kaghee.chatapp.repos;

import com.greenfox.kaghee.chatapp.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
