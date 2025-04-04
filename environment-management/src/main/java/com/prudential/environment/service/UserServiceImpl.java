package com.prudential.environment.service;

import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.UserDTO;
import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.User;
import com.prudential.environment.exception.ResourceNotFoundException;
import com.prudential.environment.mapper.BookingMapper;
import com.prudential.environment.mapper.ProjectMapper;
import com.prudential.environment.mapper.UserMapper;
import com.prudential.environment.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream().
                map(UserMapper.INSTANCE::userToUserDTO).collect(Collectors.toList());
        return userDTOList;
    }

    @Override
    public UserDTO createBooking(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.userDTOtoUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user =userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User id not found : " + id));
        if(Objects.nonNull(user)){
            userRepository.deleteById(id);
        }

    }

}
