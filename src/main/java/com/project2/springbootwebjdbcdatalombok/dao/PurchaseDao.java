package com.project2.springbootwebjdbcdatalombok.dao;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.PurchaseEntity;

@Repository
public interface PurchaseDao extends JpaRepository<PurchaseEntity, Integer> {

}
