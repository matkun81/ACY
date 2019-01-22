package com.by.viktor.repository;

import com.by.viktor.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    List<Message> findByName(String name);
}
