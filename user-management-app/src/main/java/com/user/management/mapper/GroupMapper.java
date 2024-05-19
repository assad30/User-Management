package com.user.management.mapper;

import com.user.management.dto.GroupDTO;
import com.user.management.model.Groups;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.swing.*;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    GroupDTO groupToGroupDTO(Groups group);
    Groups groupDTOToGroup(GroupDTO groupDTO);
}