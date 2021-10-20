package com.element.trailsmanager

import com.element.trailsmanager.booking.BookingFacade
import com.element.trailsmanager.trail.TrailFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@TestPropertySource(locations = ["application.properties"])
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@Transactional
@Rollback
abstract class BasicIntegrationSpec extends Specification {

    @Autowired
    BookingFacade bookingFacade

    @Autowired
    TrailFacade trailFacade

}
