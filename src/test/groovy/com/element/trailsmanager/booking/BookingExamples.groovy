package com.element.trailsmanager.booking

import com.element.trailsmanager.booking.dto.BookingRequest
import com.element.trailsmanager.booking.dto.HikerDto

trait BookingExamples {
    BookingRequest bookingRequestWithSingleHiker = BookingRequest.builder()
            .trailName("shire")
            .hikers(List.of(new HikerDto("Mateusz", 27)))
            .build()

    BookingRequest bookingRequestWithSingleHikerForMordor = BookingRequest.builder()
            .trailName("mordor")
            .hikers(List.of(new HikerDto("Mateusz", 27)))
            .build()

    BookingRequest bookingRequestForNotExistingTrail = BookingRequest.builder()
            .trailName("Test")
            .hikers(List.of(new HikerDto("Mateusz", 27)))
            .build()

    BookingRequest bookingRequestWithMultipleHikers = BookingRequest.builder()
            .trailName("shire")
            .hikers(List.of(
                    new HikerDto("Mateusz", 27),
                    new HikerDto("Andrzej", 35),
            ))
            .build()

    BookingRequest bookingRequestWithHikersWithNotSuitableAge = BookingRequest.builder()
            .trailName("shire")
            .hikers(List.of(
                    new HikerDto("Mateusz", 27),
                    new HikerDto("Andrzej", 35),
                    new HikerDto("Tomasz", 3),
                    new HikerDto("Antoni", 101),
            ))
            .build()
}