package com.by.viktor.repository;

import com.by.viktor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByUsername(String username);
}
