package com.by.Viktor.Controller;

import com.by.Viktor.Model.Message;
import com.by.Viktor.Model.Role;
import com.by.Viktor.Model.User;
import com.by.Viktor.Repository.MessageRepository;
import com.by.Viktor.Repository.UserRepository;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {

    @Autowired
    MessageRepository repository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    public String getAll(Map<String,Object> model){
        Iterable<User> users = userRepository.findAll();
        Iterable<Message> messages = repository.findAll();
        model.put("users", users);
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
@PostMapping("adminrole")
    public String adminRole(@RequestParam Long id){
        User userFromDb = userRepository.getOne(id);
        userFromDb.getRoles().add(Role.ADMIN);
        userRepository.save(userFromDb);
        return "redirect:/admin";
    }
    @PostMapping("userrole")
    public String userRole(@RequestParam Long id){
        User userFromDb = userRepository.getOne(id);
        userFromDb.getRoles().clear();
        userFromDb.getRoles().add(Role.User);
        userRepository.save(userFromDb);
        return "redirect:/admin";
    }
}
