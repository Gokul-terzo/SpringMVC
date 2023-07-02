package com.springpractise.SpringMVC.services;

import com.springpractise.SpringMVC.dto.EventDto;
import com.springpractise.SpringMVC.models.Event;

import java.util.List;

public interface EventService {
    void createEvent(int clubId, EventDto eventDto);
    List<EventDto> findAllEvents();

    EventDto findByEventId(Long eventId);

    void updateEvent(EventDto event);
}
