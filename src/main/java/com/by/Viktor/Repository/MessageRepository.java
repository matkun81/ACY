package com.by.Viktor.Repository;

import com.by.Viktor.Model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    public List<Message> findByName(String name);
}
