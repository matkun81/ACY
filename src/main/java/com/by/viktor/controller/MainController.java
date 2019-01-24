package com.by.viktor.controller;

import com.by.viktor.model.Message;
import com.by.viktor.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/connect")
public class MainController {

    @Autowired
    MessageRepository repository;

    @GetMapping
    public String con(Map<String, Object> model) {

        return "connect";
    }

    @PostMapping
    public void add(Message message, Map<String, Object> model) {
        if (message.getName().equals("") || message.getEmail().equals("") || message.getNumberPhone().equals("") || message.getThemeQwest().equals("") || message.getQwest().equals("")) {
            model.put("check", "Необходимо заполнить все поля");
        } else {
            model.put("success", "Ваше сообщение отправлено");
            repository.save(message);
        }
    }
}
