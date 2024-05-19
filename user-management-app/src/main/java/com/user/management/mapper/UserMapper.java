package com.user.management.mapper;


import com.user.management.dto.UserDTO;
import com.user.management.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "groups", source = "groups")
    UserDTO userToUserDTO(Users user);

    @Mapping(target = "groups", source = "groups")
    Users userDTOToUser(UserDTO userDTO);
}
