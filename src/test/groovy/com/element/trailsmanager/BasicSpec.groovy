package com.element.trailsmanager

import com.element.trailsmanager.booking.BookingFacade
import com.element.trailsmanager.booking.BookingFacadeConfiguration
import com.element.trailsmanager.trail.TrailFacade
import com.element.trailsmanager.trail.TrailFacadeConfiguration
import spock.lang.Specification

abstract class BasicSpec extends Specification {
    TrailFacade trailFacade = new TrailFacadeConfiguration().trailFacade()
    BookingFacade bookingFacade = new BookingFacadeConfiguration().bookingFacade(trailFacade)
}
