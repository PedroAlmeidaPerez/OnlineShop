package com.task2.student2.repository;

import com.task2.student2.model.Category;
import com.task2.student2.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}