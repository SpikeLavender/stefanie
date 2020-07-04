package com.natsumes.stefanie.service;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.OrderCreateForm;
import com.natsumes.stefanie.entity.vo.OrderVo;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Response<OrderVo> create(Integer uId, OrderCreateForm orderCreateForm);

    Response<PageInfo> list(Integer uId, Integer pageNum, Integer pageSize);

    Response<OrderVo> detail(Integer uId, String orderNo);

    Response cancel(Integer uId, String orderNo);

    void paid(String orderNo);

}
