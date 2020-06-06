package com.tomatos.service.impl;

import com.tomatos.data.dto.ProductDto;
import com.tomatos.persistence.domain.Product;
import com.tomatos.persistence.repository.ProductRepository;
import com.tomatos.service.RestaurantProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantProductServiceImpl implements RestaurantProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getProductsByCategory(Long id) {
        List<Product> result = productRepository.getAllProductsByMenuCategory(id);
        return result.stream().map(p -> mapEntityToDto(p)).collect(Collectors.toList());
    }

    private ProductDto mapEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCode(product.getCode());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setPriority(product.getPriority());
        return productDto;
    }
}
