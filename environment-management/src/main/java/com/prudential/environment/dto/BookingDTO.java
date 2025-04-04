package com.prudential.environment.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String owner;
    private String purpose;
    private String notes;
    private String bookingId;
    private String environmentName;
    private String projectId;
    private int version;
}
