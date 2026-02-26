package org.example.tparchi26022026.exercice4.userservice.service;

import org.example.tparchi26022026.exercice4.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    boolean existsById(Long id);
}
