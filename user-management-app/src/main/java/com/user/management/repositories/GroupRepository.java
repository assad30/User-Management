package com.user.management.repositories;


import com.user.management.model.Groups;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groups, Long> {
}

