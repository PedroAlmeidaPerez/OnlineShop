package com.task2.student2.service;

import com.task2.student2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Awdul on 28.07.2017.
 */
public interface ProductService {
        Page<Product> listAllByPage(Pageable pageable);
}
