package com.element.trailsmanager.trail;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "trails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Trail {
    @Id
    UUID id;
    String name;
    LocalTime startAt;
    LocalTime endAt;
    int minimumAge;
    int maximumAge;
    BigDecimal unitPrice;
}
