package com.prudential.environment.service;

import com.prudential.environment.dto.EnvironmentCount;
import com.prudential.environment.dto.EnvironmentDTO;
import com.prudential.environment.dto.EnvironmentResponse;
import com.prudential.environment.entity.Environment;
import com.prudential.environment.mapper.EnvironmentMapper;
import com.prudential.environment.repository.EnvironmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    private final EnvironmentRepository environmentRepository;

    public EnvironmentServiceImpl(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }

    @Override
    public List<EnvironmentDTO> getAllEnvironments() {
        List<Object[]> environments = environmentRepository.findEnvironmentProjectDetails();
        return environments.stream().map(objects ->
                new EnvironmentDTO(
                        (String) objects[0],
                        (String) objects[1],
                        objects[2] != null ? ((java.sql.Date) objects[2]).toLocalDate() : null,
                        objects[3] != null ? ((java.sql.Date) objects[3]).toLocalDate() : null,
                        (String) objects[4],
                        (String) objects[5],
                        (Integer) objects[6],
                        (String) objects[7],
                        (String) objects[8]

                )).collect(Collectors.toList());

    }
}
