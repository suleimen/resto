package com.tomatos.service;

import com.tomatos.data.dto.ProductDto;

import java.util.List;

public interface RestaurantProductService {

    List<ProductDto> getProductsByCategory(Long id);

}
