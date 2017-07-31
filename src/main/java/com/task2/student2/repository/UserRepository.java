package com.task2.student2.repository;

import com.task2.student2.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
}
