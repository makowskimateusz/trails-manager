package com.element.trailsmanager.booking;

import com.element.trailsmanager.booking.dto.BookingRequest;
import com.element.trailsmanager.booking.dto.BookingResponse;
import com.element.trailsmanager.booking.dto.HikerDto;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static com.element.trailsmanager.booking.BookingStatus.OPEN;
import static java.util.stream.Collectors.toSet;

class BookingMapper {
    static BookingResponse toDto(Booking booking) {
        return BookingResponse.builder()
                .bookingId(booking.getId())
                .totalCost(booking.getTotalCost())
                .bookingStatus(booking.getBookingStatus())
                .hikers(booking.getHikers())
                .build();
    }

    static Booking toEntity(BookingRequest bookingRequest, BigDecimal totalCost) {
        final Set<String> hikers = bookingRequest.getHikers().stream().map(HikerDto::getName).collect(toSet());
        return Booking.builder()
                .id(UUID.randomUUID())
                .bookingStatus(OPEN)
                .hikers(hikers)
                .trailName(bookingRequest.getTrailName())
                .totalCost(totalCost)
                .build();
    }
}
