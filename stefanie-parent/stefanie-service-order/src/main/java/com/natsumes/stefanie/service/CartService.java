package com.natsumes.stefanie.service;


import com.natsumes.stefanie.entity.Cart;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.CartAddForm;
import com.natsumes.stefanie.entity.form.CartUpdateForm;
import com.natsumes.stefanie.entity.vo.CartVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartService {

    Response<CartVo> add(Integer uId, CartAddForm form);

    Response<CartVo> list(Integer uId);

    Response<Boolean> exist(Integer uId, Integer productId);

    Response<CartVo> update(Integer uId, Integer productId, CartUpdateForm form);

    Response<CartVo> delete(Integer uId, Integer productId);

    Response<CartVo> selectAll(Integer uId);

    Response<CartVo> unSelectAll(Integer uId);

    Response<Integer> sum(Integer uId);

    List<Cart> listForCart(Integer uId);

}
