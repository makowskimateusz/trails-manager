package com.element.trailsmanager.booking;

import com.element.trailsmanager.trail.dto.TrailResponse;

import java.math.BigDecimal;

class TotalBookingCostCalculator {
    static BigDecimal calculateTotalCost(long hikersCount, TrailResponse trailResponse) {
        return trailResponse.getUnitPrice().multiply(new BigDecimal(hikersCount));
    }
}