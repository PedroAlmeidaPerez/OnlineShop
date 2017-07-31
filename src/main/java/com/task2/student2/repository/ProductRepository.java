package com.task2.student2.repository;

import com.task2.student2.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;
/**
 * Created by Awdul on 24.07.2017.
 */

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findAllByOrderByPriceAsc();
    public List<Product> findAllByOrderByPriceDesc();
    public List<Product> findAllByName(String name);
    public List<Product> findAllByCategoryId(int category_id);
    public List<Product> findAllByOrderByNameAsc();
    public List<Product> findAllByOrderByNameDesc();

}
