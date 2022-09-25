package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	

	@PostMapping("")
	public PurchaseHistoryPojo createPurchaseHistory(@RequestBody PurchaseHistoryPojo purchaseHistoryPojo) throws ApplicationException{
		return purchaseHistoryService.createPurchaseHistory(purchaseHistoryPojo);
	}
	
	@PutMapping("")
	public PurchaseHistoryPojo updatePurchaseHistory(@RequestBody PurchaseHistoryPojo purchaseHistoryPojo) throws ApplicationException{
		return purchaseHistoryService.updatePurchaseHistory(purchaseHistoryPojo);
	}
	
	@DeleteMapping("/{pid}")
	public void deletePurchaseHistory(@PathVariable("pid") int id) throws ApplicationException{
		purchaseHistoryService.deletePurchaseHistory(id);
	}
}
