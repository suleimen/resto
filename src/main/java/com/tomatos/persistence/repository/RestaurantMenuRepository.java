package com.tomatos.persistence.repository;

import com.tomatos.persistence.domain.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

    @Query("SELECT r FROM RestaurantMenu r WHERE r.restaurant.id =?1 AND r.isActive=true")
    List<RestaurantMenu> getRestaurantMenus(Long restaurantId);


}
