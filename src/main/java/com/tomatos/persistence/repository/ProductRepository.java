package com.tomatos.persistence.repository;

import com.tomatos.persistence.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.menuCategory.id=?1")
    List<Product> getAllProductsByMenuCategory(Long menuCategoryId);
}
