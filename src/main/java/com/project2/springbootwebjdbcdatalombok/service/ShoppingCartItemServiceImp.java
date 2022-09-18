package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.ShoppingCartItemDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProfileEntity;
import com.project2.springbootwebjdbcdatalombok.entity.ShoppingCartItemEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;
import com.project2.springbootwebjdbcdatalombok.pojo.ShoppingCartItemPojo;

@Service
public class ShoppingCartItemServiceImp implements ShoppingCartItemService {

	@Autowired
	ShoppingCartItemDao shoppingCartItemDao;
	
	@Override
	public List<ShoppingCartItemPojo> getAllShoppingCartItem() throws ApplicationException {
		// TODO Auto-generated method stub
		List<ShoppingCartItemEntity> shoppingCartItemEntities = shoppingCartItemDao.findAll();
		List<ShoppingCartItemPojo> shoppingCartItemPojos = new ArrayList<ShoppingCartItemPojo>();
		for(ShoppingCartItemEntity ent : shoppingCartItemEntities) {
			ShoppingCartItemPojo shoppingCartItemPojo = new ShoppingCartItemPojo();
			shoppingCartItemPojo.setProductID(ent.getProductID());
			shoppingCartItemPojo.setQuantity(ent.getQuantity());
			shoppingCartItemPojo.setShoppingStatusID(ent.getShoppingStatusID());
			shoppingCartItemPojo.setUserID(ent.getUserID());
			shoppingCartItemPojo.setShoppingID(ent.getShoppingID());
			
			shoppingCartItemPojos.add(shoppingCartItemPojo);
		}
		return shoppingCartItemPojos;
	}

	@Override
	public ShoppingCartItemPojo getOneShoppingCartItem(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartItemPojo createShoppingCartItem(ShoppingCartItemPojo shoppingCartItemPojo)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartItemPojo updateShoppingCartItem(ShoppingCartItemPojo shoppingCartItemPojo)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteShoppingCartItem(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShoppingCartItemPojo> getAllShoppingCartItemForOne(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		List<ShoppingCartItemEntity> shoppingCartItemEntities = shoppingCartItemDao.findByUserID(id);
		List<ShoppingCartItemPojo> shoppingCartItemPojos = new ArrayList<ShoppingCartItemPojo>();
		for(ShoppingCartItemEntity ent : shoppingCartItemEntities) {
			ShoppingCartItemPojo shoppingCartItemPojo = new ShoppingCartItemPojo();
			shoppingCartItemPojo.setProductID(ent.getProductID());
			shoppingCartItemPojo.setQuantity(ent.getQuantity());
			shoppingCartItemPojo.setShoppingStatusID(ent.getShoppingStatusID());
			shoppingCartItemPojo.setUserID(ent.getUserID());
			shoppingCartItemPojo.setShoppingID(ent.getShoppingID());
			
			shoppingCartItemPojos.add(shoppingCartItemPojo);
		}
		return shoppingCartItemPojos;
	}

}
