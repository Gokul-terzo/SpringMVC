package com.springpractise.SpringMVC.controller;

import com.springpractise.SpringMVC.dto.ClubDto;
import com.springpractise.SpringMVC.dto.EventDto;
import com.springpractise.SpringMVC.models.Event;
import com.springpractise.SpringMVC.services.EventService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> events=eventService.findAllEvents();
        model.addAttribute("events",events);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId,Model model){
        EventDto eventDto=eventService.findByEventId(eventId);
        model.addAttribute("event",eventDto);
        return "events-detail";
    }
    @GetMapping("/events/{clubId}/new")
    public String creatEventFrom(@PathVariable("clubId") int clubId, Model model){
       Event event=new Event();
       model.addAttribute("clubId",clubId);
       model.addAttribute("event",event);
       return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") int clubId,
                              @ModelAttribute("event")EventDto eventDto,Model model){
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/"+clubId;
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId")Long eventId,Model model){
        EventDto event=eventService.findByEventId(eventId);
        model.addAttribute("event",event);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId,
                             @Valid @ModelAttribute("club") EventDto event,
                             BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("event",event);
            return "events-edit";
        }
        EventDto eventDto=eventService.findByEventId(eventId);

        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "events-list";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") long eventId){
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }
}
