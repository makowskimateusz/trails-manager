package com.element.trailsmanager.booking

import com.element.trailsmanager.BasicSpec
import com.element.trailsmanager.common.NotFoundException
import com.element.trailsmanager.trail.TrailsExamples

import static com.element.trailsmanager.booking.BookingStatus.CANCEL
import static org.assertj.core.api.Assertions.assertThat

class BookingFacadeSpec extends BasicSpec implements TrailsExamples, BookingExamples {

    def "should book for single hiker"() {
        given:
        trailFacade.add(gondorTrail)
        trailFacade.add(mordorTrail)
        when:
        def result = bookingFacade.book(bookingRequestWithSingleHikerForMordor)
        then:
        assertThat(result)
                .hasFieldOrPropertyWithValue("totalCost", new BigDecimal("99.90"))
    }

    def "should not book for single hiker when trail does not exists"() {
        when:
        bookingFacade.book(bookingRequestForNotExistingTrail)
        then:
        thrown(NotFoundException)
    }

    def "should book for multiple hikers"() {
        given:
        trailFacade.add(shireTrail)
        when:
        def result = bookingFacade.book(bookingRequestWithMultipleHikers)
        then:
        assertThat(result)
                .hasFieldOrPropertyWithValue("totalCost", new BigDecimal("59.80"))
    }

    def "should not book for hikers with not accepted age"() {
        given:
        trailFacade.add(shireTrail)
        when:
        def result = bookingFacade.book(bookingRequestWithHikersWithNotSuitableAge)
        then:
        assertThat(result)
                .hasFieldOrPropertyWithValue("totalCost", new BigDecimal("59.80"))
    }

    def "should get booking"() {
        given:
        trailFacade.add(shireTrail)
        def bookingResult = bookingFacade.book(bookingRequestWithSingleHiker)
        when:
        def bookingResponse = bookingFacade.get(bookingResult.getBookingId())
        then:
        assertThat(bookingResponse)
                .hasFieldOrPropertyWithValue("totalCost", new BigDecimal("29.90"))
                .hasFieldOrPropertyWithValue("bookingId", bookingResult.getBookingId())
    }

    def "should get error when booking does not exists"() {
        when:
        bookingFacade.get(UUID.randomUUID())
        then:
        thrown(NotFoundException)
    }

    def "should cancel existing booking"() {
        given:
        trailFacade.add(shireTrail)
        def bookingResponse = bookingFacade.book(bookingRequestWithSingleHiker)
        when:
        bookingFacade.cancel(bookingResponse.getBookingId())
        then:
        def bookingResult = bookingFacade.get(bookingResponse.getBookingId())
        assertThat(bookingResult)
                .hasFieldOrPropertyWithValue("bookingStatus", CANCEL)
    }

    def "should get error when booking to cancel does not exists"() {
        when:
        bookingFacade.cancel(UUID.randomUUID())
        then:
        thrown(NotFoundException)
    }


}
