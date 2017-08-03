package com.task2.student2.service;

import com.task2.student2.model.PageParameters;
import com.task2.student2.model.Product;
import com.task2.student2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import com.task2.student2.repository.ProductDAO;

//
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

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


    public Iterable<Product> getProductsSortedAndPagedByParameters() {
        Direction direction = setSortingDirection(PageParameters.sortingDirection);
        return productRepository.findAll(new PageRequest(
                Integer.parseInt(PageParameters.pageNumber),
                Integer.parseInt(PageParameters.pageSize),
                direction,
                PageParameters.sortingProperty));
    }

    private Direction setSortingDirection(String sortingDirection) {
        Direction direction;
        switch (sortingDirection){
            case "Asc":
                direction = Direction.ASC;
                break;
            case "Desc":
                direction = Direction.DESC;
                break;
            default:
                direction = Direction.ASC;
                break;
        }
        return direction;
    }

    public Page<Product> listAllByPage(Pageable pageable){
        return null;
    }

}
