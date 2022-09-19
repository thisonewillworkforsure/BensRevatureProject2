package com.project2.springbootwebjdbcdatalombok.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseHistoryPojo {
	
	int purchaseHistoryID;
	int purchaseID;
	int shoppingID;
}
