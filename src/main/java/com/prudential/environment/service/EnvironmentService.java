package com.prudential.environment.service;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.EnvironmentDTO;
import com.prudential.environment.dto.EnvironmentResponse;

import java.util.List;

public interface EnvironmentService {

    List<EnvironmentDTO> getAllEnvironments();

}
