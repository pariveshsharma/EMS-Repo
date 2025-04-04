package com.prudential.environment.mapper;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.EnvironmentDTO;
import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.Environment;
import com.prudential.environment.entity.EnvironmentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface EnvironmentMapper {

    EnvironmentMapper INSTANCE = Mappers.getMapper(EnvironmentMapper.class);

    @Mapping(source = "status", target = "statusName",qualifiedByName = "mapStatusToString")
    EnvironmentDTO environmentToEnvironmentDTO(Environment environment);
    Environment environmentDTOToEnvironment(EnvironmentDTO environmentDTO);

    @Named("mapStatusToString")
    default String mapStatusToString(EnvironmentStatus status) {
        return status != null ?  status.getStatusName() :"Unknown";
    }
//    default String mapStatusToString(Set<EnvironmentStatus> statuses) {
//        if (statuses == null || statuses.isEmpty()) {
//            return "Unknown";  // Default value
//        }
//        return statuses.stream()
//                .map(EnvironmentStatus::getStatusName)
//                .collect(Collectors.joining(", ")); // Combine multiple statuses
//    }
}
