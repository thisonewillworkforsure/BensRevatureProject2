package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.PurchaseHistoryEntity;

@Repository
public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistoryEntity, Integer> {

	List<PurchaseHistoryEntity> findByPurchaseHistoryID(int id);
}
