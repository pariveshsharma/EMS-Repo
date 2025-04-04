package com.prudential.environment.service;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.ProjectDTO;
import com.prudential.environment.dto.ProjectResponse;
import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.Project;
import com.prudential.environment.exception.ResourceNotFoundException;
import com.prudential.environment.mapper.BookingMapper;
import com.prudential.environment.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public interface ProjectService {

    ProjectResponse getAllProjectsDetails();
}
