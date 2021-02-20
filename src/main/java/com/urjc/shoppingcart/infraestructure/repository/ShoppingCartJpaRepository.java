package com.urjc.shoppingcart.infraestructure.repository;

import com.urjc.shoppingcart.infraestructure.model.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Integer> {
}
