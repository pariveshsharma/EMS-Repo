package com.prudential.environment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="environment")
public class Environment {


    @Id
    @Column(name = "environment_name")
    private String environmentName;

    @Column(name = "environment_type")
    private String environmentType;

    @Column(name = "start_date",nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date",nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")  // ✅ Corrected ManyToOne
    private EnvironmentStatus status;

    @Column(name = "assigned_engineer")
    private String assignedEngineer;

    @Version
    private Integer version;

//    @ManyToMany
//    @JoinTable(
//            name = "project_environment",  // ✅ Fixed naming to match Project
//            joinColumns = @JoinColumn(name = "environment_name"),  // ✅ Uses primary key from Environment
//            inverseJoinColumns = @JoinColumn(name = "project_id")  // ✅ Uses primary key from Project
//    )
//    private List<Project> projects;

    @ManyToMany(mappedBy = "environments")  // ✅ Mapped by Project entity
    private List<Project> projects;



}
