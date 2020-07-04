package com.natsumes.stefanie.service;


import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.SearchForm;
import com.natsumes.stefanie.entity.vo.ProductDetailVo;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Response<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    Response<ProductDetailVo> detail(Integer productId);

    Response<PageInfo> search(SearchForm searchForm, Integer pageNum, Integer pageSize);

}
