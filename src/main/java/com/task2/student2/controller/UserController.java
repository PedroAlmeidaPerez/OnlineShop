package com.task2.student2.controller;

import com.task2.student2.model.User;
import com.task2.student2.service.RoleService;
import com.task2.student2.service.UserDetailsServiceImpl;
import com.task2.student2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.task2.student2.service.RolService;

@Controller
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImp;
    @Autowired
    private RoleService roleService;


    @GetMapping("/admin/createuser")
    public String createAllUsers(Model model) {
      //  model.addAllAttributes("users", userDetailsServiceImpl.loadUserByUsername(username));
        //model.addAttribute("users", userDetailsServiceImpl.getAllUsers());
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "createuser";
    }
    @PostMapping("/saveuser")
    public String saveUser(Model model,@ModelAttribute(value="user") User user) {
        userServiceImp.save(user);
        model.addAttribute("user",user);
        //userDetailsServiceImpl.addUser(user);
        return "resultuser";
    }

    @RequestMapping("/admin/allusers")
    public String showUsers(Model model) {
        model.addAttribute("users", userServiceImp.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        return "allusers";
    }

    /*@RequestMapping("/admin/products")
    public String getAdminProductsView(Model modelAndView) {
        modelAndView.addAttribute("products", productServiceImpl.getAllProducts());
        return "adminproducts";
    }*/

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
