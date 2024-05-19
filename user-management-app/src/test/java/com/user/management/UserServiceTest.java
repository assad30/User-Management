package com.user.management;


import com.user.management.dto.UserDTO;
import com.user.management.mapper.UserMapper;
import com.user.management.model.Users;
import com.user.management.repositories.UserRepository;
import com.user.management.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

public class UserServiceTest {

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void testCreateUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        Users user = new Users();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setEmail("test@example.com");

        Mockito.when(userRepository.save(any(Users.class))).thenReturn(user);

        UserDTO userDTO = userMapper.userToUserDTO(user);
        UserDTO createdUser = userService.createUser(userDTO);

        assertEquals("testuser", createdUser.getUsername());
        assertEquals("password", createdUser.getPassword());
        assertEquals("test@example.com", createdUser.getEmail());
    }

    @Test
    public void testGetUserById() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        Users user = new Users();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("password");
        user.setEmail("test@example.com");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserDTO> foundUser = userService.getUserById(1L);

        assertEquals("testuser", foundUser.get().getUsername());
        assertEquals("password", foundUser.get().getPassword());
        assertEquals("test@example.com", foundUser.get().getEmail());
    }
}
