package com.by.Viktor.Repository;

import com.by.Viktor.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByUsername(String username);
}
