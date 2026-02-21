package com.lms.lms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}