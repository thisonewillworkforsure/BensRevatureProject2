package com.project2.springbootwebjdbcdatalombok.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistoryPojo {

	private float totalCost;
	private String purchaseDate;
	private String purchases; 
}
