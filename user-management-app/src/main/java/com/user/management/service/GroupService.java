package com.user.management.service;




import com.user.management.dto.GroupDTO;
import com.user.management.mapper.GroupMapper;
import com.user.management.model.Groups;

import com.user.management.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper = GroupMapper.INSTANCE;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupDTO createGroup(GroupDTO groupDTO) {
        Groups group = groupMapper.groupDTOToGroup(groupDTO);
        Groups savedGroup = groupRepository.save(group);
        return groupMapper.groupToGroupDTO(savedGroup);
    }

    public List<GroupDTO> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(groupMapper::groupToGroupDTO)
                .collect(Collectors.toList());
    }

    public Optional<GroupDTO> getGroupById(Long id) {
        Optional<Groups> group = groupRepository.findById(id);
        return group.map(groupMapper::groupToGroupDTO);
    }
}
