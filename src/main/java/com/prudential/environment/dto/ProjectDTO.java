package com.prudential.environment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectManager;
    private String status;
    private String environmentName;
    private String environmentType;
    private Integer version;

    public ProjectDTO(String projectId, String projectName, LocalDate startDate, LocalDate endDate,
                      String projectManager, String status, Integer version, String environmentName, String environmentType) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectManager = projectManager;
        this.status = status;
        this.environmentName = environmentName;
        this.environmentType = environmentType;
        this.version = version;
    }
}
