package com.tomatos.service;

import com.tomatos.data.dto.RestaurantMenuDto;

import java.util.List;

public interface RestaurantMenuService {

    List<RestaurantMenuDto> getRestaurantMenus(Long restaurantId);

}
