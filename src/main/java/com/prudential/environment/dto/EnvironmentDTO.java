package com.prudential.environment.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EnvironmentDTO {

    private String environmentName;
    private String environmentType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String statusName;
    private String assignedEngineer;
    private String projectId;
    private String projectName;
    private Integer version;

    public EnvironmentDTO(String environmentName, String environmentType,LocalDate startDate, LocalDate endDate,
                          String statusName,String assignedEngineer,Integer version, String projectId,
                          String projectName) {
        this.environmentName = environmentName;
        this.version = version;
        this.projectName = projectName;
        this.projectId = projectId;
        this.assignedEngineer = assignedEngineer;
        this.statusName = statusName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.environmentType = environmentType;
    }
}
