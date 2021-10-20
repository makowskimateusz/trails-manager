package com.element.trailsmanager.booking;

import com.element.trailsmanager.trail.TrailFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public
class BookingFacadeConfiguration {

    @Bean
    public BookingFacade bookingFacade(TrailFacade trailFacade, BookingRepository bookingRepository) {
        return new BookingFacadeImpl(new BookingService(trailFacade, bookingRepository));
    }

    public BookingFacade bookingFacade(TrailFacade trailFacade) {
        return bookingFacade(trailFacade, new InMemoryBookingRepository());
    }

}
