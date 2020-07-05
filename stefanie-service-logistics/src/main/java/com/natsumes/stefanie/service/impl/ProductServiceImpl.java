package com.natsumes.stefanie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.enums.ProductStatusEnum;
import com.natsumes.stefanie.entity.form.SearchForm;
import com.natsumes.stefanie.enums.ResponseEnum;
import com.natsumes.stefanie.mapper.ProductMapper;
import com.natsumes.stefanie.pojo.Product;
import com.natsumes.stefanie.service.CategoryService;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.vo.ProductDetailVo;
import com.natsumes.stefanie.entity.vo.ProductVo;
import com.natsumes.stefanie.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Response<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();

        if (categoryId != null) {
            categoryService.findSubCategoryId(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);
        return getPageInfoResponseVo(products);
    }

    @Override
    public Response<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);

        if (product == null) {
            return Response.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }

        if (product.getStatus().equals(ProductStatusEnum.OFF_SALE.getCode())
                || product.getStatus().equals(ProductStatusEnum.DELETE.getCode())) {
            return Response.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }

        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);

        //敏感数据处理
        productDetailVo.setStock(product.getStock() > 100 ? 100 : product.getStock());

        return Response.success(productDetailVo);
    }

    @Override
    public Response<PageInfo> search(SearchForm searchForm, Integer pageNum, Integer pageSize) {
        //根据不同条件去查询
        Set<Integer> categoryIdSet = new HashSet<>();

        if (searchForm.getCategoryId() != null) {
            categoryService.findSubCategoryId(searchForm.getCategoryId(), categoryIdSet);
            categoryIdSet.add(searchForm.getCategoryId());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectSelective(categoryIdSet, searchForm);
        return getPageInfoResponseVo(products);
    }

    @SuppressWarnings("unchecked")
    private Response<PageInfo> getPageInfoResponseVo(List<Product> products) {
        PageInfo pageInfo = new PageInfo<>(products);
        List<ProductVo> productVos = products.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                })
                .collect(Collectors.toList());
        pageInfo.setList(productVos);
        return Response.success(pageInfo);
    }
}
