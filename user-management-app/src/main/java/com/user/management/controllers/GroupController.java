package com.user.management.controllers;




import com.user.management.dto.GroupDTO;
import com.user.management.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDTO> createGroup(@Valid @RequestBody GroupDTO groupDTO) {
        GroupDTO savedGroup = groupService.createGroup(groupDTO);
        return ResponseEntity.ok(savedGroup);
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        List<GroupDTO> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable Long id) {
        Optional<GroupDTO> group = groupService.getGroupById(id);
        return group.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

