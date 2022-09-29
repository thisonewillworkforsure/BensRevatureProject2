package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.PurchaseHistoryEntity;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchaseHistoryPojo;

@Repository
public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistoryEntity, Integer> {
	
	List<PurchaseHistoryEntity> findByPurchaseHistoryID(int id);
}
