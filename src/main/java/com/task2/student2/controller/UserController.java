package com.task2.student2.controller;

import com.task2.student2.model.User;
import com.task2.student2.service.UserDetailsServiceImpl;
import com.task2.student2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import com.task2.student2.service.RolService;

@Controller
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImp;
    /*@Autowired
    private RolService rolService;
*/
    @GetMapping("/admin/createuser")
    public String showAllUsers(Model model) {
      //  model.addAllAttributes("users", userDetailsServiceImpl.loadUserByUsername(username));
        //model.addAttribute("users", userDetailsServiceImpl.getAllUsers());
        model.addAttribute("user", new User());
        return "createuser";
    }
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute(value="user") User user) {
        userServiceImp.save(user);
        //userDetailsServiceImpl.addUser(user);
        return "resultuser";
    }

    /*@GetMapping("/admin/createrol")
    public String showAllRols(Model model) {
    //    model.addAttribute("userrols", rolService.getAllRols());
        model.addAttribute("userrol", new UserRole());
        return "createrol";
    }


    @PostMapping("/saverol")
    public String saveRol(@ModelAttribute(value="rol") UserRole userRole) {
        rolService.addRole(userRole);
        return "resultrol";
    }*/
}
