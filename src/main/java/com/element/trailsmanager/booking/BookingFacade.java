package com.element.trailsmanager.booking;

import com.element.trailsmanager.booking.dto.BookingRequest;
import com.element.trailsmanager.booking.dto.BookingResponse;
import com.element.trailsmanager.common.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

public interface BookingFacade {

    BookingResponse book(BookingRequest bookingRequest);

    BookingResponse get(UUID bookingId);

    void cancel(UUID bookingId);
}

@RequiredArgsConstructor
class BookingFacadeImpl implements BookingFacade {

    private final BookingService bookingService;

    @Override
    public BookingResponse book(BookingRequest bookingRequest) {
        return bookingService.book(bookingRequest);
    }

    @Override
    public BookingResponse get(UUID bookingId) {
        return bookingService.findById(bookingId)
                .orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    @Override
    public void cancel(UUID bookingId) {
        bookingService.cancel(bookingId);
    }
}
