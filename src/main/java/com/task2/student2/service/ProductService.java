package com.task2.student2.service;

import com.task2.student2.model.Product;
//import com.task2.student2.repository.ProductDAO;
import com.task2.student2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){//(SortingProductsOptions sortingProductsOptions){
//        switch (sortingProductsOptions) {
//            case sortByNameAsc:
//                return productRepository.findAllByOrderByNameAsc();
//            case sortByNameDesc:
//                return productRepository.findAllByOrderByNameDesc();
//            case sortByPriceAsc:
//
//            case sortByPriceDesc:
//
//        }
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    /*public void addProduct(Product product){
        productRepository.save(product);
    }*/


    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductById(int id){
        return productRepository.findOne(id);
    }
    public Product getProduct(int id){
        return productRepository.findOne(id);
    }

    public void updateProduct(Product product){
        addProduct(product);
    }

    public void deleteProduct(int id){
        productRepository.delete(id);
    }


    public List<Product> getProductsSortedBy(String sortingType) {
        switch(sortingType){
            case "sortNameAsc":
                return productRepository.findAllByOrderByNameAsc();
            case "sortNameDesc":
                return productRepository.findAllByOrderByNameDesc();
            case "sortPriceAsc":
                return productRepository.findAllByOrderByPriceAsc();
            case "sortPriceDesc":
                return productRepository.findAllByOrderByPriceDesc();
            default:
                return productRepository.findAllByOrderByNameAsc();
        }
    }
}
