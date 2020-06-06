package com.tomatos.controller;

import com.tomatos.data.dto.ProductDto;
import com.tomatos.service.RestaurantProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class RestaurantProductController {

    @Autowired
    private RestaurantProductService restaurantProductService;

    @GetMapping("/category/{categoryId}")
    List<ProductDto> getProducts(@PathVariable Long categoryId) {
        return restaurantProductService.getProductsByCategory(categoryId);
    }
}
