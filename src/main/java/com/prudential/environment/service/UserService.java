package com.prudential.environment.service;

import com.prudential.environment.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUser();

    UserDTO createBooking(UserDTO userDTO);

    void deleteUser(Long id);
}
