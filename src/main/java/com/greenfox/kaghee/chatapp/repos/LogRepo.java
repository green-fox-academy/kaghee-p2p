package com.greenfox.kaghee.chatapp.repos;

import com.greenfox.kaghee.chatapp.models.LogEntry;
import org.springframework.data.repository.CrudRepository;

public interface LogRepo extends CrudRepository<LogEntry, Long> {
}
