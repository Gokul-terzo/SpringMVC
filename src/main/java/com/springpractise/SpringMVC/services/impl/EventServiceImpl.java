package com.springpractise.SpringMVC.services.impl;

import com.springpractise.SpringMVC.dto.EventDto;
import com.springpractise.SpringMVC.models.Club;
import com.springpractise.SpringMVC.models.Event;
import com.springpractise.SpringMVC.repository.ClubRepository;
import com.springpractise.SpringMVC.repository.EventRepository;
import com.springpractise.SpringMVC.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springpractise.SpringMVC.mapper.EventMapper.mapToEvent;
import static com.springpractise.SpringMVC.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }



    @Override
    public void createEvent(int clubId, EventDto eventDto) {
        Club club=clubRepository.findById(clubId).get();
        Event event=mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events=eventRepository.findAll();
        return events.stream().map(event->mapToEventDto(event)).collect(Collectors.toList());
    }


    @Override
    public EventDto findByEventId(Long eventId) {
        Event event =eventRepository.findById(eventId);
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event=mapToEvent(eventDto);
        eventRepository.save(event);
    }


}
