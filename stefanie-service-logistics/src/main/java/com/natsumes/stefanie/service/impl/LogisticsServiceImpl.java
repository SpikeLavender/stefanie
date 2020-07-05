package com.natsumes.stefanie.service.impl;

import com.natsumes.stefanie.mapper.ProductMapper;
import com.natsumes.stefanie.pojo.Product;
import com.natsumes.stefanie.service.LogisticsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectProductById(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectByProductIdSet(Set<Integer> productIdSet) {
        return productMapper.selectByProductIdSet(productIdSet);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }
}
