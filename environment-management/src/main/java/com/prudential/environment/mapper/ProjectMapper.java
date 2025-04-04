package com.prudential.environment.mapper;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.ProjectDTO;
import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);


     ProjectDTO projectToProjectDTO(Project project);
     Project projectDTOToProject(ProjectDTO projectDTO);
}
