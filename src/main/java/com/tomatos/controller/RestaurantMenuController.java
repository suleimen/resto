package com.tomatos.controller;

import com.tomatos.data.dto.MenuCategoryDto;
import com.tomatos.data.dto.ProductDto;
import com.tomatos.data.dto.RestaurantMenuDto;
import com.tomatos.service.RestaurantMenuCategoryService;
import com.tomatos.service.RestaurantMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class RestaurantMenuController {

    @Autowired
    private RestaurantMenuService restaurantMenuService;

    @Autowired
    private RestaurantMenuCategoryService restaurantMenuCategoryService;



    @GetMapping("/{restaurantId}")
    List<RestaurantMenuDto> getRestaurantMenus(@PathVariable Long restaurantId) {
        return restaurantMenuService.getRestaurantMenus(restaurantId);
    }

    @GetMapping("/category/{restaurantMenuId}")
    List<MenuCategoryDto> getCategories(@PathVariable Long restaurantMenuId) {
        return restaurantMenuCategoryService.getMenuCategories(restaurantMenuId);
    }
}
