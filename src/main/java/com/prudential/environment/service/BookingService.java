package com.prudential.environment.service;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.BookingResponse;
import com.prudential.environment.entity.Booking;

import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    BookingDTO getBookingById(String id);
    BookingResponse getAllBookings();
    BookingDTO updateBooking(String id,BookingDTO bookingDTO);
    void deleteBooking(String id);
}
