package com.springpractise.SpringMVC.services;

import com.springpractise.SpringMVC.dto.RegistrationDto;
import com.springpractise.SpringMVC.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
