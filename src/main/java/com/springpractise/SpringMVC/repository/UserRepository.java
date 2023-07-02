package com.springpractise.SpringMVC.repository;

import com.springpractise.SpringMVC.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long > {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
