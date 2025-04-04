package com.prudential.environment.controller;


import com.prudential.environment.dto.EnvironmentDTO;
import com.prudential.environment.dto.EnvironmentResponse;
import com.prudential.environment.service.EnvironmentService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/environment")
public class EnvironmentController {
    private final EnvironmentService environmentService;

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<EnvironmentDTO>> getAllEnvironment(){
        List<EnvironmentDTO> environmentResponse =
                environmentService.getAllEnvironments();
        return new ResponseEntity<>(environmentResponse, HttpStatus.OK);

    }
}
