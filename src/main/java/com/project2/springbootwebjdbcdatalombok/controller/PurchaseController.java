package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
