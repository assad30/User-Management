package com.user.management.service;

import com.user.management.dto.UserDTO;
import com.user.management.mapper.UserMapper;
import com.user.management.model.Users;
import com.user.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        Users users = userMapper.userDTOToUser(userDTO);
        Users savedUser = userRepository.save(users);
        return userMapper.userToUserDTO(savedUser);
    }

    public Optional<UserDTO> getUserById(Long id) {
        Optional<Users> user = userRepository.findById(id);
        return user.map(userMapper::userToUserDTO);
    }

    public Optional<UserDTO> getUserByUsername(String username) {
        Optional<Users> user = userRepository.findByUsername(username);
        return user.map(userMapper::userToUserDTO);
    }
}
