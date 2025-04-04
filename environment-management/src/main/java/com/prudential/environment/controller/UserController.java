package com.prudential.environment.controller;


import com.prudential.environment.dto.BookingDTO;
import com.prudential.environment.dto.ProjectResponse;
import com.prudential.environment.dto.UserDTO;
import com.prudential.environment.service.ProjectService;
import com.prudential.environment.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
@Tag(name = "User", description = "Create and get User Information")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTO = userService.getAllUser();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO>  createBooking(@RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = userService.createBooking(userDTO);
        return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


}
