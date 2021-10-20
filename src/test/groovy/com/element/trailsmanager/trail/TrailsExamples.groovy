package com.element.trailsmanager.trail

import com.element.trailsmanager.trail.dto.TrailRequest
import groovy.transform.CompileStatic

import java.time.LocalTime

@CompileStatic
trait TrailsExamples {
    TrailRequest shireTrail = TrailRequest.builder()
            .name("Shire")
            .startAt(LocalTime.of(7, 0))
            .endAt(LocalTime.of(9, 0))
            .minimumAge(5)
            .maximumAge(100)
            .unitPrice(new BigDecimal("29.90"))
            .build()

    TrailRequest gondorTrail = TrailRequest.builder()
            .name("Gondor")
            .startAt(LocalTime.of(10, 0))
            .endAt(LocalTime.of(13, 0))
            .minimumAge(11)
            .maximumAge(50)
            .unitPrice(new BigDecimal("59.90"))
            .build()

    TrailRequest mordorTrail = TrailRequest.builder()
            .name("Mordor")
            .startAt(LocalTime.of(14, 0))
            .endAt(LocalTime.of(19, 0))
            .minimumAge(18)
            .maximumAge(40)
            .unitPrice(new BigDecimal("99.90"))
            .build()
}