package com.prudential.environment.mapper;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    BookingDTO bookingToBookingDTO(Booking booking);

    Booking bookingDTOToBooking(BookingDTO bookingDTO);
}
