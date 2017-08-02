package com.task2.student2.controller;
import com.task2.student2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin(Model modelAndView) {
        modelAndView.addAttribute("products", productServiceImpl.getAllProducts());
        return "adminproducts";
    }

   @RequestMapping("/user")
   public String getUserProductsView(Model modelAndView){
       modelAndView.addAttribute("products", productServiceImpl.getAllProducts());
       return "/user/userproducts";
    }
    /*@Autowired
    private ProductService productService;
    //    Model modelAndView;
    public String listOfProductsView(Model modelAndView){
        modelAndView.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/user")
    public void getHomeView(Model modelAndView){
        listOfProductsView(modelAndView);

    }*/

    @GetMapping("/productspublic")
    public String getProductsView(Model modelAndView){
        modelAndView.addAttribute("products", productServiceImpl.getAllProducts());
        return "/productspublic";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
