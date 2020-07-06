package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.ShippingForm;
import com.natsumes.stefanie.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/{userId}/shippings")
    public Response add(@PathVariable Integer userId, @Valid @RequestBody ShippingForm form) {
        return shippingService.add(userId, form);
    }

    @DeleteMapping("/{userId}/shippings/{shippingId}")
    public Response delete(@PathVariable Integer userId, @PathVariable Integer shippingId) {
        return shippingService.delete(userId, shippingId);
    }

    @PutMapping("/{userId}/shippings/{shippingId}")
    public Response update(@PathVariable Integer userId, @PathVariable Integer shippingId,
                           @Valid @RequestBody ShippingForm form) {
        return shippingService.update(userId, shippingId, form);
    }

    @GetMapping("/{userId}/shippings")
    public Response list(@PathVariable Integer userId,
                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return shippingService.list(userId, pageNum, pageSize);
    }
}
