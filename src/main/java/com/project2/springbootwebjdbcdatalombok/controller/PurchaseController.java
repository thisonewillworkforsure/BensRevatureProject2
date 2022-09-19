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
import com.project2.springbootwebjdbcdatalombok.pojo.PurchasePojo;
import com.project2.springbootwebjdbcdatalombok.service.PurchaseService;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping("")
	public List<PurchasePojo> getAllPurchase() throws ApplicationException{
		return purchaseService.getAllPurchase();
	}
	
	@GetMapping("/{pid}")
	public List<PurchasePojo> getAllPurchaseForOne(@PathVariable("pid") int userID) throws ApplicationException{
		return purchaseService.getAllPurchaseForOne(userID);
	}
	
	@PostMapping("")
	public PurchasePojo createPurchase(@RequestBody PurchasePojo purchasePojo) throws ApplicationException{
		return purchaseService.createPurchase(purchasePojo);
	}
	
	@PutMapping("")
	public PurchasePojo updatePurchase(@RequestBody PurchasePojo purchasePojo) throws ApplicationException{
		return purchaseService.updatePurchase(purchasePojo);
	}
	
	@DeleteMapping("/{pid}")
	void deletePurchase(@PathVariable("pid") int id) throws ApplicationException{
		purchaseService.deletePurchase(id);
	}
	
}
