package com.element.trailsmanager.trail;

import com.element.trailsmanager.trail.dto.TrailRequest;
import com.element.trailsmanager.trail.dto.TrailResponse;

import static java.util.UUID.randomUUID;

class TrailMapper {
    static Trail toEntity(TrailRequest trailRequest) {
        return Trail.builder()
                .id(randomUUID())
                .name(trailRequest.getName())
                .minimumAge(trailRequest.getMinimumAge())
                .maximumAge(trailRequest.getMaximumAge())
                .startAt(trailRequest.getStartAt())
                .endAt(trailRequest.getEndAt())
                .unitPrice(trailRequest.getUnitPrice())
                .build();
    }

    static TrailResponse toDto(Trail trail) {
        return TrailResponse.builder()
                .name(trail.getName())
                .startAt(trail.getStartAt())
                .endAt(trail.getEndAt())
                .minimumAge(trail.getMinimumAge())
                .maximumAge(trail.getMaximumAge())
                .unitPrice(trail.getUnitPrice())
                .build();
    }
}
