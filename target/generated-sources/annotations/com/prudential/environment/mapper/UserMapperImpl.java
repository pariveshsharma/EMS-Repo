package com.prudential.environment.mapper;

import com.prudential.environment.dto.UserDTO;
import com.prudential.environment.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-07T13:24:00+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.14 (OpenLogic)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUserName( user.getUserName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setUserRole( user.getUserRole() );

        return userDTO;
    }

    @Override
    public User userDTOtoUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setUserName( userDTO.getUserName() );
        user.setEmail( userDTO.getEmail() );
        user.setUserRole( userDTO.getUserRole() );

        return user;
    }
}
