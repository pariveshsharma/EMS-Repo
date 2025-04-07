package com.prudential.environment.mapper;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.BookingDTO.BookingDTOBuilder;
import com.prudential.environment.entity.Booking;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-07T13:24:00+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.14 (OpenLogic)"
)
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO bookingToBookingDTO(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDTOBuilder bookingDTO = BookingDTO.builder();

        bookingDTO.projectName( booking.getProjectName() );
        bookingDTO.startDate( booking.getStartDate() );
        bookingDTO.endDate( booking.getEndDate() );
        bookingDTO.status( booking.getStatus() );
        bookingDTO.owner( booking.getOwner() );
        bookingDTO.purpose( booking.getPurpose() );
        bookingDTO.notes( booking.getNotes() );
        bookingDTO.bookingId( booking.getBookingId() );
        bookingDTO.environmentName( booking.getEnvironmentName() );
        bookingDTO.projectId( booking.getProjectId() );
        if ( booking.getVersion() != null ) {
            bookingDTO.version( booking.getVersion() );
        }

        return bookingDTO.build();
    }

    @Override
    public Booking bookingDTOToBooking(BookingDTO bookingDTO) {
        if ( bookingDTO == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setBookingId( bookingDTO.getBookingId() );
        booking.setProjectName( bookingDTO.getProjectName() );
        booking.setStartDate( bookingDTO.getStartDate() );
        booking.setEndDate( bookingDTO.getEndDate() );
        booking.setStatus( bookingDTO.getStatus() );
        booking.setOwner( bookingDTO.getOwner() );
        booking.setPurpose( bookingDTO.getPurpose() );
        booking.setNotes( bookingDTO.getNotes() );
        booking.setEnvironmentName( bookingDTO.getEnvironmentName() );
        booking.setProjectId( bookingDTO.getProjectId() );
        booking.setVersion( bookingDTO.getVersion() );

        return booking;
    }
}
