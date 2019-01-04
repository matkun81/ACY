package com.by.Viktor.Controller;

import com.by.Viktor.Model.Message;
import com.by.Viktor.Repository.MessageRepository;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    MessageRepository repository;

    @GetMapping("/admin")
    public String getAll(Map<String,Object> model){
        Iterable<Message> messages = repository.findAll();
        model.put("messages",messages);
        return "admin";
    }
@PostMapping("filter")
    public String filter(@RequestParam String name,Map<String,Object> model){
        if (name.isEmpty()){
            Iterable<Message> messages= repository.findAll();
            model.put("messages", messages);
        }
        else {
            List<Message> messages = repository.findByName(name);
            model.put("messages", messages);
        }
    return "admin";
}
@PostMapping("/delete")
public String delete(@RequestParam String some, Map<String,Object> model){
repository.deleteById(Long.parseLong(some));
Iterable<Message> messages = repository.findAll();
model.put("messages",messages);
        return "admin";
}

}
