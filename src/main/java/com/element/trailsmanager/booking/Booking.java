package com.element.trailsmanager.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;


@Builder
@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    UUID id;
    String trailName;
    @ElementCollection
    Set<String> hikers;
    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;
    BigDecimal totalCost;
}
