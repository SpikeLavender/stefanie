package com.natsumes.stefanie.service.impl;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.LogisticsApplicationTests;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.SearchForm;
import com.natsumes.stefanie.entity.vo.ProductDetailVo;
import com.natsumes.stefanie.enums.ResponseEnum;
import com.natsumes.stefanie.service.ProductService;
import com.natsumes.stefanie.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
@Slf4j
public class ProductServiceImplTest extends LogisticsApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void list() {
        Response<PageInfo> responseVo = productService.list(null, 1, 2);
        log.info("responseVo={}", JSONUtils.printFormat(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }


    @Test
    public void detail() {
        Response<ProductDetailVo> detail = productService.detail(26);
        log.info("responseVo={}", JSONUtils.printFormat(detail));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), detail.getStatus());
    }

    @Test
    public void search() {
        SearchForm searchForm = new SearchForm("华为", new BigDecimal(100), new BigDecimal(1000), null);
        Response<PageInfo> detail = productService.search(searchForm, 1, 2);
        log.info("responseVo={}", JSONUtils.printFormat(detail));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), detail.getStatus());
    }
}