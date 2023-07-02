package com.springpractise.SpringMVC.repository;

import com.springpractise.SpringMVC.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {

}
