package com.prudential.environment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="project")
public class Project {

    @Id
    @Column(name="project_id")
    private String projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_manager")
    private String projectManager;

    @Column(name="start_date",nullable = false)
    private LocalDate startDate;

    @Column(name="end_date",nullable = false)
    private LocalDate endDate;

    @Column(name = "status")
    private String status;

    @ManyToMany
    @JoinTable(
            name = "project_environment",  // ✅ Ensures join table matches database
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "environment_name")
    )
    private List<Environment> environments;

    @Version
    private Integer version;


}
