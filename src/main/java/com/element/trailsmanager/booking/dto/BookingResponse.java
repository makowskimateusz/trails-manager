package com.element.trailsmanager.booking.dto;

import com.element.trailsmanager.booking.BookingStatus;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class BookingResponse {
    UUID bookingId;
    BigDecimal totalCost;
    BookingStatus bookingStatus;
    Set<String> hikers;
}
