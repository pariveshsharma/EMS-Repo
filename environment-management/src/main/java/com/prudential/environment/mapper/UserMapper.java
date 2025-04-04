package com.prudential.environment.mapper;

import com.prudential.environment.dto.UserDTO;
import com.prudential.environment.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);
}
