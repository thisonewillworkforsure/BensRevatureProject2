package com.project2.springbootwebjdbcdatalombok.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productID;
	
	@Column(name="product_Name")
	private String productName;
	
	@Column(name="product_Desc")
	private String productDesc;
	
	@Column(name="product_Img")
	private String productImg;
	
	@Column(name="product_cost", columnDefinition = "NUMERIC(8,2)")
	private double productCost;
}


