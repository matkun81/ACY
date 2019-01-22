package com.by.viktor.controller;

import com.by.viktor.model.Role;
import com.by.viktor.model.User;
import com.by.viktor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public  String addNewUser(User user, Map<String,Object> model){
        User userFromDb = userRepository.findAllByUsername(user.getUsername());
        if (userFromDb!=null){
            model.put("message","User exist");
        } else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.User));
            userRepository.save(user);
            return "redirect:/login";
        }
        return "registration";
    }
}
