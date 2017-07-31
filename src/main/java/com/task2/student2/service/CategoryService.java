package com.task2.student2.service;

import com.task2.student2.model.Product;
import com.task2.student2.repository.CategoryRepository;
import com.task2.student2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awdul on 25.07.2017.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<com.task2.student2.model.Category> getAllcategories(){
        List<com.task2.student2.model.Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public void addCategory(com.task2.student2.model.Category category){
        categoryRepository.save(category);
    }

    public com.task2.student2.model.Category getcategoryById(int id){
        return categoryRepository.findOne(id);
    }

    public void updateCategory(com.task2.student2.model.Category category){
        addCategory(category);
    }

    public void deleteCategory(int id){
        categoryRepository.delete(id);
    }

    public List<Product> getAllProductsFromCategory(int id){
        return productRepository.findAllByCategoryId(id);
    }

}
