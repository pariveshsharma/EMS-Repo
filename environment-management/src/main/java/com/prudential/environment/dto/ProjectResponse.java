package com.prudential.environment.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {

    private Long activeProjectCount;
    List<ProjectDTO> projectDTOList;
}
