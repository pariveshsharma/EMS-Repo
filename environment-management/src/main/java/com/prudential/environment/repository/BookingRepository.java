package com.prudential.environment.repository;

import com.prudential.environment.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {
    Optional<Booking> findTopByOrderByBookingIdDesc();
}
