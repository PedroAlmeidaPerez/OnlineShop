package com.task2.student2.repository;

import com.task2.student2.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long>{
}