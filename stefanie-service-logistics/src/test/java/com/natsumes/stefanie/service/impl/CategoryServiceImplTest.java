package com.natsumes.stefanie.service.impl;

import com.natsumes.stefanie.LogisticsApplicationTests;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.vo.CategoryVo;
import com.natsumes.stefanie.enums.ResponseEnum;
import com.natsumes.stefanie.service.CategoryService;
import com.natsumes.stefanie.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Slf4j
public class CategoryServiceImplTest extends LogisticsApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void selectAll() {
        Response<List<CategoryVo>> responseVo = categoryService.selectAll();
        log.info("data={}", JSONUtils.printFormat(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void findSubCategoryId() {
        Set<Integer> resultSet = new HashSet<>();
        categoryService.findSubCategoryId(100001, resultSet);
        log.info("set = {}", JSONUtils.printFormat(resultSet));
    }
}