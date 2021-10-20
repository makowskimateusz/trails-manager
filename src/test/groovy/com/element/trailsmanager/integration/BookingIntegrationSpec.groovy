package com.element.trailsmanager.integration

import com.element.trailsmanager.BasicIntegrationSpec
import com.element.trailsmanager.booking.BookingExamples
import com.element.trailsmanager.trail.TrailsExamples
import org.assertj.core.api.Assertions


class BookingIntegrationSpec extends BasicIntegrationSpec implements BookingExamples, TrailsExamples {

    def "should book trail"() {
        given:
        trailFacade.add(shireTrail)
        trailFacade.add(gondorTrail)
        when:
        def bookingResponse = bookingFacade.book(bookingRequestWithSingleHiker)
        then:
        def bookingResult = bookingFacade.get(bookingResponse.getBookingId())
        Assertions.assertThat(bookingResult)
                .hasFieldOrPropertyWithValue("totalCost", new BigDecimal("29.90"))
    }
}