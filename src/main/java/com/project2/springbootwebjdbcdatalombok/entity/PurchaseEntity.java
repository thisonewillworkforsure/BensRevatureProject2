package com.project2.springbootwebjdbcdatalombok.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "purchase")
public class PurchaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private int purchaseID;
	
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "total_cost", columnDefinition = "NUMERIC(10,2")
	private double totalCost;
	
	@Column(name = "purchase_date")
	private String purchaseDate;
	
	@ManyToMany
	@JoinTable(name="purchase_history", 
	  joinColumns = @JoinColumn(name = "purchase_id"), 
	  inverseJoinColumns = @JoinColumn(name = "shopping_id"))
	  List<ShoppingCartItemEntity> shoppingCartItemEntities;
}
