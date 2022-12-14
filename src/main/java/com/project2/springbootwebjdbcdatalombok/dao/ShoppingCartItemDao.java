package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.ShoppingCartItemEntity;

@Repository
public interface ShoppingCartItemDao extends JpaRepository<ShoppingCartItemEntity, Integer> {

	@Query(value = "SELECT * FROM shopping_cart_item WHERE user_id = ?1 AND shopping_status_id != 2 ORDER BY shopping_id ASC", nativeQuery = true)
	  List<ShoppingCartItemEntity> findByUserID(int id);
	
}
