package com.springpractise.SpringMVC.repository;

import com.springpractise.SpringMVC.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {

    Event findById(Long eventId);
}
