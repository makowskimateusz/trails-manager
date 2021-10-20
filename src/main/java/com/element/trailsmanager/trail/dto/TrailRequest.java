package com.element.trailsmanager.trail.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalTime;

@Value
@Builder
public class TrailRequest {
    String name;
    @JsonFormat(pattern = "hh:mm")
    LocalTime startAt;
    @JsonFormat(pattern = "hh:mm")
    LocalTime endAt;
    int minimumAge;
    int maximumAge;
    BigDecimal unitPrice;
}
