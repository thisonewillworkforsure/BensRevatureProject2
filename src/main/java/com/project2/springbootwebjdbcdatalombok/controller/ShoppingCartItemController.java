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
	
	@PostMapping("")
	public ShoppingCartItemPojo createShoppingCartItem(@RequestBody ShoppingCartItemPojo shoppingCartItemPojo) throws ApplicationException {
		return shoppingCartItemService.createShoppingCartItem(shoppingCartItemPojo);
	}
	
	@PutMapping("")
	public ShoppingCartItemPojo updateShoppingCartItem(@RequestBody ShoppingCartItemPojo shoppingCartItemPojo) throws ApplicationException{
		return shoppingCartItemService.updateShoppingCartItem(shoppingCartItemPojo);
	}
	
	@DeleteMapping("/{sid}")
	public void deleteShoppingCartItem(@PathVariable("sid") int id) throws ApplicationException{
		shoppingCartItemService.deleteShoppingCartItem(id);
	}
}
