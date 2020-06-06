package com.tomatos.service.impl;

import com.tomatos.data.dto.RestaurantDto;
import com.tomatos.persistence.domain.*;
import com.tomatos.persistence.repository.ProductRepository;
import com.tomatos.persistence.repository.RestaurantRepository;
import com.tomatos.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public RestaurantDto getById(Long id) {
        Restaurant restaurant = restaurantRepository.getOne(id);
        return entityToDto(restaurant);
    }

    @Override
    public List<RestaurantDto> getAll() {
        return restaurantRepository.getAllRestaurant()
                .stream()
                .map(p -> entityToDto(p))
                .collect(Collectors.toList());
    }

    @Override
    public void create(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setCode(dto.getCode());
        restaurant.setName(dto.getName());
        restaurantRepository.save(restaurant);
    }

    @Override
    public void update(RestaurantDto dto) {
        Restaurant restaurant = restaurantRepository.getOne(dto.getId());
        if (restaurant != null) {
            restaurant.setName(dto.getName());
            restaurant.setCode(dto.getCode());
            restaurantRepository.save(restaurant);
        }
    }

    @Override
    public void remove(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public void fetchAll(Long id) {
        
    }

    private RestaurantDto entityToDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setCode(restaurant.getCode());
        restaurantDto.setName(restaurant.getName());
        return restaurantDto;
    }
}
