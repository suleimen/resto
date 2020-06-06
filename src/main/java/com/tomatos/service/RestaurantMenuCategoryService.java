package com.tomatos.service;

import com.tomatos.data.dto.MenuCategoryDto;

import java.util.List;

public interface RestaurantMenuCategoryService {

    List<MenuCategoryDto> getMenuCategories(Long menuCategoryId);

}
