package com.by.viktor.controller;

import com.by.viktor.model.Message;
import com.by.viktor.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void add(@RequestParam String name, @RequestParam String email,
                    @RequestParam String numberPhone, @RequestParam String themeQwest,
                    @RequestParam String qwest, Map<String, Object> model) {
        if (name.equals("") || email.equals("") || numberPhone.equals("") || themeQwest.equals("") || qwest.equals("")) {
            model.put("check", "Необходимо заполнить все поля");
        } else {
            model.put("success", "Ваше сообщение отправлено");
            Message message = new Message(name, email, numberPhone, themeQwest, qwest);
            repository.save(message);
        }
//        return "connect";
    }
}
