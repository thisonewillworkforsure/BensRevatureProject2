package com.project2.springbootwebjdbcdatalombok.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopping_id")
	private int shoppingID;
	
	@Column(name = "shopping_status_id")
	private int shoppingStatusID;
	
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "product_id")
	private int productID;
	
	@Column(name = "quantity")
	private int quantity;
}
