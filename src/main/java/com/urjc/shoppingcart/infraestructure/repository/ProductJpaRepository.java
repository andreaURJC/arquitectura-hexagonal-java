package com.urjc.shoppingcart.infraestructure.repository;

import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {}
