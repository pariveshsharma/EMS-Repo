package com.prudential.environment.mapper;

import com.prudential.environment.dto.ProjectDTO;
import com.prudential.environment.entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-07T13:24:00+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.14 (OpenLogic)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDTO projectToProjectDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setProjectId( project.getProjectId() );
        projectDTO.setProjectName( project.getProjectName() );
        projectDTO.setStartDate( project.getStartDate() );
        projectDTO.setEndDate( project.getEndDate() );
        projectDTO.setProjectManager( project.getProjectManager() );
        projectDTO.setStatus( project.getStatus() );
        projectDTO.setVersion( project.getVersion() );

        return projectDTO;
    }

    @Override
    public Project projectDTOToProject(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectId( projectDTO.getProjectId() );
        project.setProjectName( projectDTO.getProjectName() );
        project.setProjectManager( projectDTO.getProjectManager() );
        project.setStartDate( projectDTO.getStartDate() );
        project.setEndDate( projectDTO.getEndDate() );
        project.setStatus( projectDTO.getStatus() );
        project.setVersion( projectDTO.getVersion() );

        return project;
    }
}
