package com.task2.student2.controller;


import com.task2.student2.model.PageParameters;
import com.task2.student2.model.Product;
import com.task2.student2.model.SortingType;
import com.task2.student2.service.CategoryService;
import com.task2.student2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private CategoryService categoryService;


    //    Model modelAndView;
    public String listOfProductsView(Model modelAndView) {
        modelAndView.addAttribute("products", productServiceImpl.getAllProducts());
        return "products";
    }

    @RequestMapping("/products")
    public void getHomeView(Model modelAndView) {
        listOfProductsView(modelAndView);
    }

    @RequestMapping("/admin/products")
    public String getAdminProductsView(Model modelAndView) {
        modelAndView.addAttribute("products", productServiceImpl.getAllProducts());
        return "adminproducts";
    }

    @RequestMapping("/user/products")
    public String getUserProductsView(Model modelAndView,
                                      @RequestParam(value = "sortdir", required = false) String sortingDirection,
                                      @RequestParam(value = "sortprop", required = false) String sortingProperty,
                                      @RequestParam(value = "page", required = false) String pageNumber,
                                      @RequestParam(value = "pageSize", required = false) String pageSize){
        PageParameters.setParameters(sortingDirection, sortingProperty, pageNumber, pageSize);
        modelAndView.addAttribute("products", productServiceImpl.getProductsSortedAndPagedByParameters());
        modelAndView.addAttribute("sortingTypes", SortingType.values());
        modelAndView.addAttribute("parameters", new PageParameters());
        return "userproducts";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public String getProduct(@PathVariable String id, Model modelAndView) {
        modelAndView.addAttribute("product", productServiceImpl.getProduct(Integer.parseInt(id)));
        return "productinfo";
    }


    @GetMapping("/product/create")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productServiceImpl.getAllProducts());
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllcategories());
        return "productForm";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute(value = "product") Product product) {
        productServiceImpl.addProduct(product);
        return "result";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void updateProduct(@RequestBody Product product, Model modelAndView) {
        productServiceImpl.updateProduct(product);
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
    public String delete(@PathVariable int id, Model model) {
        productServiceImpl.deleteProduct(id);
        model.addAttribute("products", productServiceImpl.getAllProducts());
        return "adminproducts";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        /*productService.getProduct(id);
        model.addAttribute("products", productService.getProduct(id));
        */
        model.addAttribute("products", productServiceImpl.getAllProducts());
        model.addAttribute("product", productServiceImpl.getProduct(id));
        return "productForm";
    }


    @RequestMapping("/admin")
    public String displayAdminPage(Model modelAndView) {
        return "admin";
    }


}
