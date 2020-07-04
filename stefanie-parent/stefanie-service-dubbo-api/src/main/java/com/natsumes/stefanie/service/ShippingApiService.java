package com.natsumes.stefanie.service;

import com.natsumes.stefanie.pojo.Shipping;

import java.util.List;
import java.util.Set;

public interface ShippingApiService {

    Shipping selectByUidAndShippingId(Integer uId, Integer shippingId);

    List<Shipping> selectShippingByIdSet(Set<Integer> shippingIdSet);

    Shipping selectByPrimaryKey(Integer shippingId);
}
