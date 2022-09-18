package com.project2.springbootwebjdbcdatalombok.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchasePojo {
	
	private int purchaseID;
	private int userID;
	private double totalCost;
	private String purchaseDate;
}
