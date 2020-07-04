package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.ShippingForm;
import com.natsumes.stefanie.pojo.User;
import com.natsumes.stefanie.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.natsumes.stefanie.consts.StefanieConst.CURRENT_USER;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/shippings")
    public Response add(@Valid @RequestBody ShippingForm form, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.add(user.getId(), form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    public Response delete(@PathVariable Integer shippingId, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.delete(user.getId(), shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    public Response update(@PathVariable Integer shippingId,
                             @Valid @RequestBody ShippingForm form,
                             HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.update(user.getId(), shippingId, form);
    }

    @GetMapping("/shippings")
    public Response list(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                         HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.list(user.getId(), pageNum, pageSize);
    }
}
