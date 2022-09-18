package com.project2.springbootwebjdbcdatalombok.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCartItemPojo {
	private int shoppingID;
	private int shoppingStatusID;
	private int userID;
	private int productID;
	private int quantity;
}
