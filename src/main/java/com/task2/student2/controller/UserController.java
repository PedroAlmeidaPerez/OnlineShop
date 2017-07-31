package com.task2.student2.controller;

import com.task2.student2.model.Product;
import com.task2.student2.model.User;
import com.task2.student2.service.ProductService;
import com.task2.student2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createuser")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllusers());
        model.addAttribute("user", new User());
        return "createuser";
    }
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute(value="user") User user) {
        userService.addUser(user);
        return "resultuser";
    }
}
