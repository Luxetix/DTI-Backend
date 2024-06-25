package com.luxetix.eventManagementWebsite.events.dto;


import com.luxetix.eventManagementWebsite.events.entity.EventType;
import com.luxetix.eventManagementWebsite.events.entity.Events;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class GetEventListDtoResponse {
    private long id;
    private String EventName;
    private String address;
    private String venueName;
    private String eventImage;
    private String descriptions;
    private String ticketName;
    private int ticketPrice;
    private String priceCategory;
    private String categoryName;
    private String cityName;
    private boolean isOnline;
    private int favoritesCount;
    private boolean isFavorite;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

}