package com.prudential.environment.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentResponse {
    private List<EnvironmentCount> environmentCount;
//    private Integer availableEnvironmentCount;
//    private Set<String> environmentItems;
    private List<EnvironmentDTO> environmentDTOList;
}
