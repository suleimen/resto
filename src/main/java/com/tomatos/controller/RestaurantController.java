package com.tomatos.controller;

import com.tomatos.data.dto.RestaurantDto;
import com.tomatos.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{id}")
    public RestaurantDto getById(@PathVariable Long id) {
        return restaurantService.getById(id);
    }

    @GetMapping("/list")
    public List<RestaurantDto> getList() {
        return restaurantService.getAll();
    }

    @PostMapping
    public void create(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.create(restaurantDto);
    }

    @PutMapping
    public void update(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.update(restaurantDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restaurantService.remove(id);
    }
}
