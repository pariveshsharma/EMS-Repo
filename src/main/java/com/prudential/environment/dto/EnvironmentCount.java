package com.prudential.environment.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnvironmentCount {
    private String environmentName;
    private Long count;
}
