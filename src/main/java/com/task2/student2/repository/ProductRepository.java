package com.task2.student2.repository;

import com.task2.student2.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.CrudRepository;

/**
 * Created by Awdul on 24.07.2017.
 */

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    public Iterable<Product> findAllByOrderByPriceAsc();
    public Iterable<Product> findAllByOrderByPriceDesc();
    public Iterable<Product> findAllByName(String name);
    public Iterable<Product> findAllByCategoryId(int id);
    public Iterable<Product> findAllByOrderByNameAsc();
    public Iterable<Product> findAllByOrderByNameDesc();
    public Iterable<Product> findAll();
}
