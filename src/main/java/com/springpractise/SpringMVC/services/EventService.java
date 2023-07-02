package com.springpractise.SpringMVC.services;

import com.springpractise.SpringMVC.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(int clubId, EventDto eventDto);
    List<EventDto> findAllEvents();
}
