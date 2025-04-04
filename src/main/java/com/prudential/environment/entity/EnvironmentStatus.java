package com.prudential.environment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="environment_status")
public class EnvironmentStatus {
    @Id
    @Column(name="status_id")
    private Integer statusId;

    @Column(name="status_name",nullable = false, unique = true)
    private String statusName;
}
