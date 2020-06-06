package com.tomatos.persistence.repository;

import com.tomatos.persistence.domain.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    @Query("SELECT m FROM MenuCategory m LEFT JOIN FETCH m.category WHERE m.restaurantMenu.id =?1")
    List<MenuCategory> getMenuCategories(Long id);
}
