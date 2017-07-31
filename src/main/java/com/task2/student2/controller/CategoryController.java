package com.task2.student2.controller;

import com.task2.student2.model.Category;
import com.task2.student2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    public String listOfCategoriesView(Model modelAndView){
        modelAndView.addAttribute("categories", categoryService.getAllcategories());
        return "categories";
    }

    @RequestMapping("/categories")
    public void getHomeView(Model modelAndView){
        listOfCategoriesView(modelAndView);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories/{id}")
    public String getCategory(@PathVariable int id, Model modelAndView){
//        modelAndView.addAttribute("category", categoryService.getcategoryById(id));
        modelAndView.addAttribute("products", categoryService.getAllProductsFromCategory(id));
        return "categoryinfo";
    }

    @RequestMapping(method = RequestMethod.POST, value="/categories")
    public void addCategory(@RequestBody Category category, Model modelAndView){
        this.categoryService.addCategory(category);
        listOfCategoriesView(modelAndView);

    }

    @RequestMapping(method=RequestMethod.PUT, value="/categories/{id}")
    public void updateCategory(@RequestBody Category category, Model modelAndView){
        this.categoryService.updateCategory(category);
        listOfCategoriesView(modelAndView);
    }

    @RequestMapping("/categories/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("category", categoryService.getAllcategories());
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("category", categoryService.getAllcategories());
        model.addAttribute("category", categoryService.getcategoryById(id));
        return "categoryform";
    }

    @RequestMapping("/admin/categories")
    public String getAdminCategoriesView(Model modelAndView){
        modelAndView.addAttribute("categories", categoryService.getAllcategories());
        return "admincategories";
    }
    @RequestMapping("admin/category/create/")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());

        return "categoryForm";
    }

    @RequestMapping(value = "/admim/category/save/", method = RequestMethod.POST)
    public String saveCategory(Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }


}
