package com.task2.student2.service;

import com.task2.student2.model.Product;
import com.task2.student2.model.User;
import com.task2.student2.repository.ProductRepository;
import com.task2.student2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
         userRepository.save(user);
    }

    public List<User> getAllusers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

}
