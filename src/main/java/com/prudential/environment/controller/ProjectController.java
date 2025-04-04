package com.prudential.environment.controller;


import com.prudential.environment.dto.EnvironmentResponse;
import com.prudential.environment.dto.ProjectResponse;
import com.prudential.environment.service.EnvironmentService;
import com.prudential.environment.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/all")
    public ResponseEntity<ProjectResponse> getAllProjects() {
        ProjectResponse projectResponse = projectService.getAllProjectsDetails();
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }

}
