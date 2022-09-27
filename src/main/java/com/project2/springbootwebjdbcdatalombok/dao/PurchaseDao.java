package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.PurchaseEntity;
import com.project2.springbootwebjdbcdatalombok.entity.ShoppingCartItemEntity;

@Repository
public interface PurchaseDao extends JpaRepository<PurchaseEntity, Integer> {

	List<PurchaseEntity> findByUserID(int id);
	
	List<PurchaseEntity> findByUserIDOrderByPurchaseIDDesc(int id);
}
