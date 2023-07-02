package com.springpractise.SpringMVC.services.impl;

import com.springpractise.SpringMVC.dto.RegistrationDto;
import com.springpractise.SpringMVC.models.Role;
import com.springpractise.SpringMVC.models.UserEntity;
import com.springpractise.SpringMVC.repository.RoleRepository;
import com.springpractise.SpringMVC.repository.UserRepository;
import com.springpractise.SpringMVC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user=new UserEntity();
        user.setUsername(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role=roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
