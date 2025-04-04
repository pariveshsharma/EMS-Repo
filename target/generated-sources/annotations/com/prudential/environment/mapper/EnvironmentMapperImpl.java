package com.prudential.environment.mapper;

import com.prudential.environment.dto.EnvironmentDTO;
import com.prudential.environment.entity.Environment;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T17:13:55+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.14 (OpenLogic)"
)
public class EnvironmentMapperImpl implements EnvironmentMapper {

    @Override
    public EnvironmentDTO environmentToEnvironmentDTO(Environment environment) {
        if ( environment == null ) {
            return null;
        }

        EnvironmentDTO environmentDTO = new EnvironmentDTO();

        environmentDTO.setStatusName( mapStatusToString( environment.getStatus() ) );
        environmentDTO.setEnvironmentName( environment.getEnvironmentName() );
        environmentDTO.setEnvironmentType( environment.getEnvironmentType() );
        environmentDTO.setStartDate( environment.getStartDate() );
        environmentDTO.setEndDate( environment.getEndDate() );
        environmentDTO.setAssignedEngineer( environment.getAssignedEngineer() );
        environmentDTO.setVersion( environment.getVersion() );

        return environmentDTO;
    }

    @Override
    public Environment environmentDTOToEnvironment(EnvironmentDTO environmentDTO) {
        if ( environmentDTO == null ) {
            return null;
        }

        Environment environment = new Environment();

        environment.setEnvironmentName( environmentDTO.getEnvironmentName() );
        environment.setEnvironmentType( environmentDTO.getEnvironmentType() );
        environment.setStartDate( environmentDTO.getStartDate() );
        environment.setEndDate( environmentDTO.getEndDate() );
        environment.setAssignedEngineer( environmentDTO.getAssignedEngineer() );
        environment.setVersion( environmentDTO.getVersion() );

        return environment;
    }
}
