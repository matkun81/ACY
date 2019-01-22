package com.by.viktor.controller;

import com.by.viktor.model.Role;
import com.by.viktor.model.User;
import com.by.viktor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequestMapping("admin/users")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    private static boolean role = false;

    @GetMapping
    public String getAllUsers(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "users";
    }

    @PostMapping
    public String adminRole(@RequestParam Long id) {
        User userFromDb = userRepository.getOne(id);
        if (role) {
            userFromDb.getRoles().add(Role.ADMIN);
            role = false;
        } else {
            userFromDb.getRoles().clear();
            userFromDb.getRoles().add(Role.User);
            role = true;
        }
        userRepository.save(userFromDb);
        return "redirect:/admin/users";
    }
}
