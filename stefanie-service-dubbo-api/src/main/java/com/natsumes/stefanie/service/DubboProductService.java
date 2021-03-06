package com.natsumes.stefanie.service;

import com.natsumes.stefanie.entity.form.SearchForm;
import com.natsumes.stefanie.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface DubboProductService {

    int deleteByPrimaryKey(Integer id);

    int insert(Product product);

    int insertSelective(Product product);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product product);

    int updateByPrimaryKey(Product product);

    List<Product> selectByCategoryIdSet(@Param("categoryIdSet") Set<Integer> categoryIdSet);

    List<Product> selectByProductIdSet(@Param("productIdSet") Set<Integer> productIdSet);

    List<Product> selectSelective(@Param("categoryIdSet") Set<Integer> categoryIdSet, @Param("searchForm") SearchForm searchForm);

}
