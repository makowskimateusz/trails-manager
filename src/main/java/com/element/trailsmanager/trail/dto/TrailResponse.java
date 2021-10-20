package com.element.trailsmanager.trail.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalTime;

@Value
@Builder
public class TrailResponse {
    String name;
    LocalTime startAt;
    LocalTime endAt;
    int minimumAge;
    int maximumAge;
    BigDecimal unitPrice;
}
