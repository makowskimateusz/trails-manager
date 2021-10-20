package com.element.trailsmanager.booking;

import com.element.trailsmanager.booking.dto.BookingRequest;
import com.element.trailsmanager.booking.dto.BookingResponse;
import com.element.trailsmanager.booking.dto.HikerDto;
import com.element.trailsmanager.common.NotFoundException;
import com.element.trailsmanager.trail.TrailFacade;
import com.element.trailsmanager.trail.dto.TrailResponse;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import static com.element.trailsmanager.booking.BookingMapper.toDto;
import static com.element.trailsmanager.booking.BookingMapper.toEntity;
import static com.element.trailsmanager.booking.BookingStatus.CANCEL;
import static com.element.trailsmanager.booking.TotalBookingCostCalculator.calculateTotalCost;

@RequiredArgsConstructor
class BookingService {

    private final TrailFacade trailFacade;
    private final BookingRepository bookingRepository;

    BookingResponse book(BookingRequest bookingRequest) {
        final TrailResponse trailResponse = trailFacade.get(bookingRequest.getTrailName());
        final long hikersCount = getHikersCountIncludingOnlyWithSuitableAge(bookingRequest, trailResponse);
        final BigDecimal totalCost = calculateTotalCost(hikersCount, trailResponse);
        final Booking booking = toEntity(bookingRequest, totalCost);
        final Booking save = bookingRepository.save(booking);
        return toDto(save);
    }

    Optional<BookingResponse> findById(UUID bookingId) {
        return bookingRepository.findById(bookingId)
                .map(BookingMapper::toDto);
    }

    @Transactional
    void cancel(UUID bookingId) {
        final Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NotFoundException("Cannot cancel non existing booking"));
        booking.setBookingStatus(CANCEL);
        bookingRepository.save(booking);
    }

    private long getHikersCountIncludingOnlyWithSuitableAge(BookingRequest bookingRequest, TrailResponse trailResponse) {
        return bookingRequest.getHikers().stream().filter(isSuitableByAge(trailResponse)).count();
    }

    private Predicate<HikerDto> isSuitableByAge(TrailResponse trailResponse) {
        return hiker -> hiker.getAge() <= trailResponse.getMaximumAge() && hiker.getAge() >= trailResponse.getMinimumAge();
    }
}
