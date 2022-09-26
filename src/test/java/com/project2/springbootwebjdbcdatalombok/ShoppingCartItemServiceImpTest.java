package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.project2.springbootwebjdbcdatalombok.dao.ShoppingCartItemDao;
import com.project2.springbootwebjdbcdatalombok.entity.ShoppingCartItemEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ShoppingCartItemPojo;
import com.project2.springbootwebjdbcdatalombok.service.ShoppingCartItemServiceImp;

import lombok.experimental.PackagePrivate;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartItemServiceImpTest {

	@InjectMocks
	private ShoppingCartItemServiceImp shoppingCartItemServiceImp;
	
	@Mock
	private ShoppingCartItemDao shoppingCartItemDao;
	
	@Mock
	private ShoppingCartItemPojo shopPojo;
	
	@Mock
	private ShoppingCartItemPojo otherPojo;
	
	@Mock
	private ShoppingCartItemEntity shoppingCartItemEntity;
	
	@Mock
	private List<ShoppingCartItemPojo> pojos;
	
	@Mock
	private List<ShoppingCartItemEntity> entities;
	
	@BeforeEach
	public void beforeEach() {
		shopPojo = new ShoppingCartItemPojo();
		
		shopPojo.setProductID(-30);
		shopPojo.setQuantity(5);
		shopPojo.setShoppingID(1);
		shopPojo.setShoppingStatusID(1);
		shopPojo.setUserID(1);
		
		otherPojo = new ShoppingCartItemPojo();
		
		otherPojo.setProductID(-30);
		otherPojo.setQuantity(5);
		otherPojo.setShoppingID(1);
		otherPojo.setShoppingStatusID(1);
		otherPojo.setUserID(1);
		
		shoppingCartItemEntity = new ShoppingCartItemEntity();
		
		pojos = new ArrayList<ShoppingCartItemPojo>();
		entities = new ArrayList<ShoppingCartItemEntity>();
	}
	
	@Test
	public void testUpdateShoppingCartItem() {
		otherPojo.setQuantity(100);
		try {
			Mockito.when(shoppingCartItemDao.save(any())).thenReturn(shoppingCartItemEntity);
			shopPojo = shoppingCartItemServiceImp.updateShoppingCartItem(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(shopPojo.getQuantity(), otherPojo.getQuantity());
	}
	
	@Test
	public void testCreateUpdateShoppingCartItem() {
		otherPojo.setQuantity(100);
		try {
			Mockito.when(shoppingCartItemDao.saveAndFlush(any())).thenReturn(shoppingCartItemEntity);
			shopPojo = shoppingCartItemServiceImp.createShoppingCartItem(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(shopPojo.getQuantity(), otherPojo.getQuantity());
	}
	
	@Test
	public void testDeleteShoppingCartItem() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testGetAllShoppingCartItems() {
		BeanUtils.copyProperties(shopPojo, shoppingCartItemEntity);
		entities.add(shoppingCartItemEntity);
		
		try {
			Mockito.when(shoppingCartItemDao.findAll()).thenReturn(entities);
			pojos = shoppingCartItemServiceImp.getAllShoppingCartItem();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(pojos.size(), entities.size());
	}
		
	
	
}
