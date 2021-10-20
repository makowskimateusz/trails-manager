package com.element.trailsmanager.booking;

import com.element.trailsmanager.booking.dto.BookingRequest;
import com.element.trailsmanager.booking.dto.BookingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
class BookingController {

    private final BookingFacade bookingFacade;

    @PostMapping
    public BookingResponse book(@RequestBody BookingRequest bookingRequest) {
        return bookingFacade.book(bookingRequest);
    }

    @GetMapping("/{bookingId}")
    public BookingResponse getByBookingId(@PathVariable UUID bookingId) {
        return bookingFacade.get(bookingId);
    }

    @DeleteMapping("/{bookingId}")
    public void cancel(@PathVariable UUID bookingId) {
        bookingFacade.cancel(bookingId);
    }
}
