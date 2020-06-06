package com.tomatos.service.impl;

import com.tomatos.data.dto.CategoryDto;
import com.tomatos.data.dto.MenuCategoryDto;
import com.tomatos.persistence.domain.Category;
import com.tomatos.persistence.domain.MenuCategory;
import com.tomatos.persistence.repository.MenuCategoryRepository;
import com.tomatos.service.RestaurantMenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantMenuCategoryServiceImpl implements RestaurantMenuCategoryService {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Override
    public List<MenuCategoryDto> getMenuCategories(Long menuCategoryId) {
        List<MenuCategory> list = menuCategoryRepository.getMenuCategories(menuCategoryId);
        return list.stream().map(p -> mapEntityToDto(p)).collect(Collectors.toList());
    }

    private MenuCategoryDto mapEntityToDto(MenuCategory menuCategory) {
        MenuCategoryDto menuCategoryDto = new MenuCategoryDto();
        menuCategoryDto.setCategoryDto(mapToDto(menuCategory.getCategory()));
        menuCategoryDto.setId(menuCategory.getId());
        menuCategoryDto.setPriority(menuCategory.getPriority());
        return menuCategoryDto;
    }

    private CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
