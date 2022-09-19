package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchaseHistoryPojo;
import com.project2.springbootwebjdbcdatalombok.service.PurchaseHistoryService;

@RestController
@RequestMapping("api/history")
public class PurchaseHistoryController {

	@Autowired
	private PurchaseHistoryService purchaseHistoryService;
	
	@GetMapping("")
	public List<PurchaseHistoryPojo> getAllPurchaseHistory() throws ApplicationException{
		return purchaseHistoryService.getAllPurchaseHistory();
	}
}
