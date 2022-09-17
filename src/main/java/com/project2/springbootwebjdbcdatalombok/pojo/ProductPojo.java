package com.project2.springbootwebjdbcdatalombok.pojo;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductPojo {

	private int productID;
	private String productName;
	private String productDesc;
	private String productImg;
	private double productCost;
}
