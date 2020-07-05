package com.natsumes.stefanie.controller;


import com.natsumes.stefanie.entity.form.SearchForm;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Response list(@RequestParam(required = false) Integer categoryId,
                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return productService.list(categoryId, pageNum, pageSize);
    }

    @GetMapping("/products/{productId}")
    public Response detail(@PathVariable Integer productId) {
        return productService.detail(productId);
    }

    @PostMapping("/products/search")
    public Response search(@RequestBody SearchForm searchForm,
                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return productService.search(searchForm, pageNum, pageSize);
    }

}
