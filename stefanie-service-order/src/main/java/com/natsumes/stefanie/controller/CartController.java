package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.CartAddForm;
import com.natsumes.stefanie.entity.form.CartUpdateForm;
import com.natsumes.stefanie.entity.vo.CartVo;
import com.natsumes.stefanie.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}/carts")
    public Response<CartVo> list(@PathVariable Integer userId) {
        return cartService.list(userId);
    }

    @PostMapping("/{userId}/carts")
    public Response<CartVo> add(@Valid @RequestBody CartAddForm form,
                                @PathVariable Integer userId) {
        return cartService.add(userId, form);
    }

    @GetMapping("/{userId}/carts/{productId}")
    public Response<Boolean> get(@PathVariable Integer productId,
                                 @PathVariable Integer userId) {
        return cartService.exist(userId, productId);
    }

    @PutMapping("/{userId}/carts/{productId}")
    public Response<CartVo> update(@PathVariable Integer productId,
                                   @Valid @RequestBody CartUpdateForm form,
                                   @PathVariable Integer userId) {
        return cartService.update(userId, productId, form);
    }

    @DeleteMapping("/{userId}/carts/{productId}")
    public Response<CartVo> delete(@PathVariable Integer productId,
                                   @PathVariable Integer userId) {
        return cartService.delete(userId, productId);
    }

    @PutMapping("/{userId}/carts/selectAll")
    public Response<CartVo> selectAll(@PathVariable Integer userId) {
        return cartService.selectAll(userId);
    }

    @PutMapping("/{userId}/carts/unSelectAll")
    public Response<CartVo> unSelectAll(@PathVariable Integer userId) {
        return cartService.unSelectAll(userId);
    }

    @GetMapping("/{userId}/carts/products/sum")
    public Response<Integer> sum(@Valid @PathVariable Integer userId) {
        return cartService.sum(userId);
    }

}
