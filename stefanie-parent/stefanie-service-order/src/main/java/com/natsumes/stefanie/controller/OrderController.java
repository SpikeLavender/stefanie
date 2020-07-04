package com.natsumes.stefanie.controller;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.OrderCreateForm;
import com.natsumes.stefanie.entity.vo.OrderVo;
import com.natsumes.stefanie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}/orders")
    public Response<PageInfo> list(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                   @PathVariable Integer userId) {
        return orderService.list(userId, pageNum, pageSize);
    }

    @PostMapping("/{userId}/orders")
    public Response<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                    @PathVariable Integer userId) {
        return orderService.create(userId, form);
    }

    @GetMapping("/{userId}/orders/{orderNo}")
    public Response<OrderVo> detail(@PathVariable String orderNo, @PathVariable Integer userId) {
        return orderService.detail(userId, orderNo);
    }

    @PutMapping("/{userId}/orders/{orderNo}")
    public Response cancel(@PathVariable String orderNo, @PathVariable Integer userId) {
        return orderService.cancel(userId, orderNo);
    }
}
