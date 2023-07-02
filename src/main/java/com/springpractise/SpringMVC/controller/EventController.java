package com.springpractise.SpringMVC.controller;

import com.springpractise.SpringMVC.dto.EventDto;
import com.springpractise.SpringMVC.models.Event;
import com.springpractise.SpringMVC.services.EventService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
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
}
