package com.project2.springbootwebjdbcdatalombok.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.ShoppingCartItemEntity;

@Repository
public interface ShoppingCartItemDao extends JpaRepository<ShoppingCartItemEntity, Integer> {

}
