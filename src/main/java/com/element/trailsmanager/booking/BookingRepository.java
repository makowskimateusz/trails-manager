package com.element.trailsmanager.booking;

import org.springframework.data.repository.Repository;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends Repository<Booking, UUID> {
    Booking save(Booking booking);

    Optional<Booking> findById(UUID bookingId);
}

class InMemoryBookingRepository implements BookingRepository {

    private final HashMap<UUID, Booking> db = new HashMap<>();

    @Override
    public Booking save(Booking booking) {
        db.put(booking.getId(), booking);
        return booking;
    }

    @Override
    public Optional<Booking> findById(UUID bookingId) {
        return Optional.ofNullable(db.get(bookingId));
    }
}
