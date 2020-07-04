package com.natsumes.stefanie.mapper;

import com.natsumes.stefanie.entity.form.SearchForm;
import com.natsumes.stefanie.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByCategoryIdSet(@Param("categoryIdSet") Set<Integer> categoryIdSet);

    List<Product> selectByProductIdSet(@Param("productIdSet") Set<Integer> productIdSet);

    List<Product> selectSelective(@Param("categoryIdSet") Set<Integer> categoryIdSet, @Param("searchForm") SearchForm searchForm);

}