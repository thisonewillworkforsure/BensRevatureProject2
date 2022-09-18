package com.project2.springbootwebjdbcdatalombok.service;

import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ShoppingCartItemPojo;

public interface ShoppingCartItemService {

	List<ShoppingCartItemPojo> getAllShoppingCartItem() throws ApplicationException;
	
	List<ShoppingCartItemPojo> getAllShoppingCartItemForOne(int id) throws ApplicationException;
	
	ShoppingCartItemPojo getOneShoppingCartItem(int id) throws ApplicationException;
	
	ShoppingCartItemPojo createShoppingCartItem(ShoppingCartItemPojo shoppingCartItemPojo) throws ApplicationException;
	
	ShoppingCartItemPojo updateShoppingCartItem(ShoppingCartItemPojo shoppingCartItemPojo) throws ApplicationException;
	
	void deleteShoppingCartItem(int id) throws ApplicationException;
}
