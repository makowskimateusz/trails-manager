package com.element.trailsmanager.booking.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class BookingRequest {
    String trailName;
    List<HikerDto> hikers;
}
