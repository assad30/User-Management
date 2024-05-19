package com.user.management;

import com.user.management.dto.UserDTO;
import com.user.management.mapper.UserMapper;
import com.user.management.model.Users;
import com.user.management.repositories.UserRepository;
import com.user.management.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserManagementAppApplicationTests {

	private final UserMapper userMapper = UserMapper.INSTANCE;


	@Test
	void contextLoads() {
	}


}
