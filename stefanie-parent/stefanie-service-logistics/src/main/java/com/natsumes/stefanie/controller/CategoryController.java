package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Response selectAll() {
        return categoryService.selectAll();
    }
}
