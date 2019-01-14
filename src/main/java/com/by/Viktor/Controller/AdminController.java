package com.by.Viktor.Controller;

import com.by.Viktor.Model.Message;
import com.by.Viktor.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
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
public String delete(@RequestParam String some){
repository.deleteById(Long.parseLong(some));
        return "redirect:/admin";
}

}
