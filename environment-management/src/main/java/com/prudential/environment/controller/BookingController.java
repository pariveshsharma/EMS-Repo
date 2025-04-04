package com.prudential.environment.controller;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.BookingResponse;
import com.prudential.environment.mapper.BookingMapper;
import com.prudential.environment.service.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@Tag(name = "Booking API", description = "Endpoints for managing bookings")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookingDTO>  createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO bookingDTO1 = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(bookingDTO1, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable(value = "id") String bookingId) {
        BookingDTO bookingDTO = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<BookingResponse> getAllBookings() {
        BookingResponse bookingDTOList = bookingService.getAllBookings();
        return new ResponseEntity<>(bookingDTOList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable(value = "id") String bookingId,@RequestBody BookingDTO bookingDTO) {
        BookingDTO bookingDTO1 = bookingService.updateBooking(bookingId,bookingDTO);
        return new ResponseEntity<>(bookingDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable(value = "id") String bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
    }
}
