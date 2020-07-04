package com.natsumes.stefanie.service;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.ShippingForm;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface ShippingService {

    Response<Map<String, Integer>> add(Integer uId, ShippingForm form);

    Response delete(Integer uId, Integer shippingId);

    Response update(Integer uId, Integer shippingId, ShippingForm form);

    Response<PageInfo> list(Integer uId, Integer pageNum, Integer pageSize);
}
