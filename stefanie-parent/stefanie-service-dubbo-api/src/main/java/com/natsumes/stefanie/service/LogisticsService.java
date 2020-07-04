package com.natsumes.stefanie.service;


import com.natsumes.stefanie.pojo.Product;

import java.util.List;
import java.util.Set;

public interface LogisticsService {

    Product selectProductById(Integer productId);

    List<Product> selectByProductIdSet(Set<Integer> productIdSet);

    int updateProduct(Product product);
}
