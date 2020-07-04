package com.natsumes.stefanie.service;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.vo.CategoryVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface CategoryService {

    /**
     * 获取所有类目
     *
     * @return
     */
    Response<List<CategoryVo>> selectAll();


    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
