package com.prudential.environment.service;

import com.prudential.environment.dto.ProjectDTO;
import com.prudential.environment.dto.ProjectResponse;
import com.prudential.environment.entity.Project;
import com.prudential.environment.mapper.ProjectMapper;
import com.prudential.environment.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponse getAllProjectsDetails() {
        List<Object[]> projects = projectRepository.findProjectDetails();
        List<ProjectDTO> projectDTOList =  projects.stream().
                map(obj -> new ProjectDTO(
                (String) obj[0],  // projectId
                (String) obj[1],  // projectName
                obj[2] != null ? ((java.sql.Date) obj[2]).toLocalDate() : null,  // startDate (COALESCE ensures it's always non-null)),    // startDate
                obj[3] != null ? ((java.sql.Date) obj[3]).toLocalDate() : null,    // endDate
                (String) obj[4],  // projectManager
                (String) obj[5],  // status
                 (Integer) obj[6], // version
                (String) obj[7],  // environmentName (COALESCE ensures it's always non-null)
                (String) obj[8]  // environmentType (COALESCE ensures it's always non-null)

        )).collect(Collectors.toList());

        Long count = projectDTOList.stream().filter(p->p.getStatus().equalsIgnoreCase("ACTIVE")).count();
        return ProjectResponse.builder().activeProjectCount(count).projectDTOList(projectDTOList).build();
    }
}
