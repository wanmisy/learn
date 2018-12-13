package com.example.concurrent.controller;


import com.example.concurrent.entity.ProductModel;
import com.example.concurrent.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/{id}")
    public ProductModel getProductById(@PathVariable("id") int id){
       return productService.getById(id);
    }
}
