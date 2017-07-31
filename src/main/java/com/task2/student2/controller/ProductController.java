package com.task2.student2.controller;


import com.task2.student2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.task2.student2.model.*;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
//    Model modelAndView;
    public String listOfProductsView(Model modelAndView){
        modelAndView.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/products")
    public void getHomeView(Model modelAndView){
        listOfProductsView(modelAndView);
    }

    @RequestMapping("/admin/products")
    public String getAdminProductsView(Model modelAndView){
        modelAndView.addAttribute("products", productService.getAllProducts());
        return "adminproducts";
    }
    @RequestMapping("/user/products")
    public String getUserProductsView(Model modelAndView){
        modelAndView.addAttribute("products", productService.getAllProducts());
        modelAndView.addAttribute("sortingTypes", SortingType.values());
        return "userproducts";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/products={sortingType}")
    public String getUserProductsViewWithSorting(@PathVariable String sortingType, Model modelAndView){
        modelAndView.addAttribute("products", productService.getProductsSortedBy(sortingType));
        modelAndView.addAttribute("sortingTypes", SortingType.values());
        return "userproducts";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public String getProduct(@PathVariable String id, Model modelAndView){
        modelAndView.addAttribute("product", productService.getProduct(Integer.parseInt(id)));
        return "productinfo";
    }


        @GetMapping("/product/create")
        public String showAllProducts(Model model) {
            model.addAttribute("products", productService.getAllProducts());
            model.addAttribute("product", new Product());
            return "productForm";
        }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute(value="product") Product product) {
        productService.addProduct(product);
        return "result";
    }



    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public void updateProduct(@RequestBody Product product, Model modelAndView){
        productService.updateProduct(product);
        listOfProductsView(modelAndView);
    }
/*
    @RequestMapping(method=RequestMethod.DELETE, value="/product/delete/{id}")
    public void deleteProduct(@PathVariable String id, Model modelAndView){
        productService.deleteProduct(id);
        listOfProductsView(modelAndView);
    }
*/
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        productService.deleteProduct(id);
        model.addAttribute("products", productService.getAllProducts());
        return "adminproducts";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        /*productService.getProduct(id);
        model.addAttribute("products", productService.getProduct(id));
        */
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", productService.getProduct(id));
        return "productForm";
    }


    @RequestMapping("/admin")
    public String displayAdminPage(Model modelAndView) {
        return "admin";
    }


}
