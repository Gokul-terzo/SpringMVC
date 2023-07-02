package com.springpractise.SpringMVC.repository;

import com.springpractise.SpringMVC.models.Role;
import com.springpractise.SpringMVC.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long > {
    Role findByName(String name);
}
