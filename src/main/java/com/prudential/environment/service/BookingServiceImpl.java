package com.prudential.environment.service;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.BookingResponse;
import com.prudential.environment.dto.EnvironmentCount;
import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.Environment;
import com.prudential.environment.entity.Project;
import com.prudential.environment.entity.ProjectEnvironment;
import com.prudential.environment.exception.ResourceNotFoundException;
import com.prudential.environment.mapper.BookingMapper;
import com.prudential.environment.repository.BookingRepository;
import com.prudential.environment.repository.EnvironmentRepository;
import com.prudential.environment.repository.ProjectEnvironmentRepository;
import com.prudential.environment.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private final ProjectRepository projectRepository;
    private final EnvironmentRepository environmentRepository;
    private final ProjectEnvironmentRepository projectEnvironmentRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ProjectRepository projectRepository, EnvironmentRepository environmentRepository, ProjectEnvironmentRepository projectEnvironmentRepository) {
        this.bookingRepository = bookingRepository;
        this.projectRepository = projectRepository;
        this.environmentRepository = environmentRepository;
        this.projectEnvironmentRepository = projectEnvironmentRepository;
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking =BookingMapper.INSTANCE.bookingDTOToBooking(bookingDTO);
        booking.setBookingId(generateBookingId());
        Booking savedBooking = bookingRepository.save(booking);
        return BookingMapper.INSTANCE.bookingToBookingDTO(savedBooking);

    }

    @Override
    public BookingDTO getBookingById(String id) {
    Booking booking = bookingRepository.findById(id).orElseThrow(() ->
           new ResourceNotFoundException("Booking id not found : " + id));
        return  BookingMapper.INSTANCE.bookingToBookingDTO(booking);
    }

    @Override
    public BookingResponse getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDTO> bookingDTOList = bookings.stream().map(BookingMapper.INSTANCE::bookingToBookingDTO).collect(Collectors.toList());

        Map<String,Long> elementCounts = bookingDTOList.stream()
                .collect(Collectors.groupingBy(BookingDTO::getEnvironmentName, Collectors.counting()));

        List<EnvironmentCount> envCount = elementCounts.entrySet().stream(
                ).map(entry -> new EnvironmentCount(entry.getKey(), entry.getValue())).collect(Collectors.toList());

        return BookingResponse.builder().bookingDTOList(bookingDTOList).environmentCount(envCount).build();
    }

    @Override
    @Transactional
    public BookingDTO updateBooking(String id, BookingDTO bookingDTO) {

        Booking booking =bookingRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Booking id not found : " + id));

        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setStatus(bookingDTO.getStatus());
        booking.setProjectName(bookingDTO.getProjectName());
        booking.setOwner(bookingDTO.getOwner());
        booking.setPurpose(bookingDTO.getPurpose());
        booking.setNotes(bookingDTO.getNotes());

        if ("Approved".equalsIgnoreCase(booking.getStatus())) {
            Project project = projectRepository.findById(booking.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found"));

            Environment environment = environmentRepository.findById(booking.getEnvironmentName())
                    .orElseThrow(() -> new RuntimeException("Environment not found"));

            boolean exists = projectEnvironmentRepository.existsByProjectAndEnvironment(project, environment);

            if (!exists) {
                ProjectEnvironment projectEnvironment = new ProjectEnvironment();
                projectEnvironment.setProject(project);
                projectEnvironment.setEnvironment(environment);
                projectEnvironmentRepository.save(projectEnvironment);
            }
        }

        Booking updatedBooking = bookingRepository.save(booking);
        return BookingMapper.INSTANCE.bookingToBookingDTO(updatedBooking);
    }

    @Override
    public void deleteBooking(String id) {
        Booking booking =bookingRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Booking id not found : " + id));
        if(Objects.nonNull(booking)){
            bookingRepository.deleteById(id);
        }
    }

    private String generateBookingId() {
        Optional<Booking> lastBooking = bookingRepository.findTopByOrderByBookingIdDesc();
        int nextId =1;
        if(lastBooking.isPresent()){
            String lastBookingId = lastBooking.get().getBookingId();
            nextId = Integer.parseInt(lastBookingId.substring(3)) + 1;
        }
        return String.format("BID%05d", nextId);
    }
}
