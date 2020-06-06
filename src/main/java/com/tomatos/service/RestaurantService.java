package com.tomatos.service;

import com.tomatos.data.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    RestaurantDto getById(Long id);

    List<RestaurantDto> getAll();

    void create(RestaurantDto dto);

    void update(RestaurantDto dto);

    void remove(Long id);


    void fetchAll(Long id);

}
