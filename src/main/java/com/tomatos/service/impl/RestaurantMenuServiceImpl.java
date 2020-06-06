package com.tomatos.service.impl;

import com.tomatos.data.dto.RestaurantMenuDto;
import com.tomatos.persistence.domain.RestaurantMenu;
import com.tomatos.persistence.repository.RestaurantMenuRepository;
import com.tomatos.service.RestaurantMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantMenuServiceImpl implements RestaurantMenuService {

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Override
    public List<RestaurantMenuDto> getRestaurantMenus(Long restaurantId) {
        List<RestaurantMenu> list = restaurantMenuRepository.getRestaurantMenus(restaurantId);
        return list.stream().map(p -> mapEntityToDto(p)).collect(Collectors.toList());
    }

    private RestaurantMenuDto mapEntityToDto(RestaurantMenu restaurantMenu) {
        RestaurantMenuDto restaurantMenuDto = new RestaurantMenuDto();
        restaurantMenuDto.setId(restaurantMenu.getId());
        restaurantMenuDto.setName(restaurantMenu.getName());
        restaurantMenuDto.setPriority(restaurantMenu.getPriority());
        return restaurantMenuDto;
    }
}
