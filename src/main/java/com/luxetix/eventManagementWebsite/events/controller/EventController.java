package com.luxetix.eventManagementWebsite.events.controller;


import com.luxetix.eventManagementWebsite.events.dao.EventListDao;
import com.luxetix.eventManagementWebsite.events.dto.EventDetailDtoResponse;
import com.luxetix.eventManagementWebsite.events.dto.GetEventListDtoResponse;
import com.luxetix.eventManagementWebsite.events.dto.NewEventRequestDto;
import com.luxetix.eventManagementWebsite.events.entity.Events;
import com.luxetix.eventManagementWebsite.events.services.EventService;
import com.luxetix.eventManagementWebsite.response.Response;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Validated
@Log
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("")
    public ResponseEntity<Response<Events>> addNewEvent(@ModelAttribute NewEventRequestDto newEventRequestDto) {
        return Response.successfulResponse("Event registered successfully", eventService.addNewEvent(newEventRequestDto));
    }

    @GetMapping("")
    public ResponseEntity<Response<List<GetEventListDtoResponse>>> getAllEvent(@RequestParam(value = "category",required = false) String category, @RequestParam(value ="city", required = false) String city, @RequestParam(value = "isPaid", required = false) Boolean isPaid, @RequestParam(value = "eventName",required = false) String eventName, @RequestParam(value = "isOnline",required = false) Boolean isOnline,@RequestParam(value = "isFavorite",required = false) Boolean isFavorite, @RequestParam(defaultValue = "0",required = false) int page, @RequestParam(defaultValue = "10",required = false) int size) {
        Page<EventListDao> data = eventService.getAllEvent(category,city,eventName,isPaid,isOnline,isFavorite, page, size);
        List<GetEventListDtoResponse> eventList = eventService.convertAllEventToDto(data);
        return Response.successfulResponseWithPage(HttpStatus.OK.value(), "All event fetched successfully",eventList,data.getTotalPages(),data.getTotalElements(),data.getNumber());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<EventDetailDtoResponse>> getEventById(@PathVariable("id") long id){
        return Response.successfulResponse("Event has been fetched succesfully", eventService.getEventById(id));
    }
}
