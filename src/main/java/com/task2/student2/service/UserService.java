package com.task2.student2.service;

import com.task2.student2.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);


}
