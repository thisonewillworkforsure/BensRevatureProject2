package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ShoppingCartItemPojo;
import com.project2.springbootwebjdbcdatalombok.service.ShoppingCartItemService;

@RestController
@RequestMapping("api/shop")
public class ShoppingCartItemController {

	@Autowired
	ShoppingCartItemService shoppingCartItemService;
	
	@GetMapping("")
	public List<ShoppingCartItemPojo> getAllShoppingCartItem() throws ApplicationException{
		return shoppingCartItemService.getAllShoppingCartItem();
	}
	
	@GetMapping("/{sid}")
	public List<ShoppingCartItemPojo> getAllShoppingCartItemForOne(@PathVariable("sid") int id) throws ApplicationException{
		return shoppingCartItemService.getAllShoppingCartItemForOne(id);
	}
}
