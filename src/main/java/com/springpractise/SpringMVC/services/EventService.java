package com.springpractise.SpringMVC.services;

import com.springpractise.SpringMVC.dto.EventDto;

public interface EventService {
    void createEvent(int clubId, EventDto eventDto);
}
