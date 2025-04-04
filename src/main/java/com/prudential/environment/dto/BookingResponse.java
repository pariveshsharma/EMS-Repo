package com.prudential.environment.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private List<EnvironmentCount> environmentCount;
    private List<BookingDTO> bookingDTOList;
}
