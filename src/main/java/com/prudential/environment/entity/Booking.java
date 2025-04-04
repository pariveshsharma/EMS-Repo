package com.prudential.environment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name="booking")
public class Booking {


    @Id
    @Column(name="booking_id")
    private String bookingId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "start_date",nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date",nullable = false)
    private LocalDate endDate;

    @Column(name = "status")
    private String status;

    @Column(name = "owner")
    private String owner;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "note")
    private String notes;

    @Column(name = "environment_name")
    private String environmentName;

    @Column(name = "project_id")
    private String projectId;

    @Version
    private Integer version;


}
