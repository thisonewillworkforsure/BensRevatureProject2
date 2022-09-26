package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.project2.springbootwebjdbcdatalombok.dao.ProfileDao;
import com.project2.springbootwebjdbcdatalombok.dao.PurchaseDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProfileEntity;
import com.project2.springbootwebjdbcdatalombok.entity.PurchaseEntity;
import com.project2.springbootwebjdbcdatalombok.entity.PurchaseHistoryEntity;
import com.project2.springbootwebjdbcdatalombok.entity.ShoppingCartItemEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchasePojo;
import com.project2.springbootwebjdbcdatalombok.pojo.ShoppingCartItemPojo;
import com.project2.springbootwebjdbcdatalombok.service.PurchaseServiceImp;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImpTest {

	@InjectMocks
	private PurchaseServiceImp purchaseServiceImp;
	
	@Mock
	private PurchasePojo purchasePojo;
	
	@Mock
	private PurchasePojo otherPojo;
	
	@Mock
	private PurchaseEntity purchaseEntity;
	
	@Mock
	private List<PurchasePojo> purchasePojos;
	
	@Mock
	private List<PurchaseEntity> purchaseEntities;
	
	@Mock
	private List<ShoppingCartItemPojo> purchasePojoItems;
	
	@Mock
	private List<ShoppingCartItemPojo> otherPojoItems;
	
	@Mock
	private PurchaseDao purchaseDao;
	
	@BeforeEach
	public void beforeEach() {
		
		purchasePojoItems = new ArrayList<ShoppingCartItemPojo>();
		
		otherPojoItems = new ArrayList<ShoppingCartItemPojo>();
		
		purchasePojo = new PurchasePojo();
		purchasePojo.setPurchaseDate("hi"); //testing this
		purchasePojo.setPurchaseID(-55);
		purchasePojo.setShoppingCartItemPojos(purchasePojoItems);
		purchasePojo.setTotalCost(1000);
		purchasePojo.setUserID(-33);
		
		otherPojo = new PurchasePojo();
		otherPojo.setPurchaseDate("hi"); //testing this
		otherPojo.setPurchaseID(-55);
		otherPojo.setShoppingCartItemPojos(purchasePojoItems);
		otherPojo.setTotalCost(1000);
		otherPojo.setUserID(-33);
		
		purchaseEntity = new PurchaseEntity();
		purchasePojos = new ArrayList<PurchasePojo>();
		purchaseEntities = new ArrayList<PurchaseEntity>();
	}
	
	@Test
	public void testUpdatePurchase() {
		purchasePojo.setTotalCost(3000);
		
		try {
			Mockito.when(purchaseDao.save(any())).thenReturn(purchaseEntity);
			purchasePojo = purchaseServiceImp.updatePurchase(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(0, 1);
		}
		assertEquals(purchasePojo.getTotalCost(), otherPojo.getTotalCost());
	}
	
	@Test
	public void testCreatePurchase() {
	purchasePojo.setTotalCost(3000);
		
		try {
			Mockito.when(purchaseDao.saveAndFlush(any())).thenReturn(purchaseEntity);
			purchasePojo = purchaseServiceImp.createPurchase(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(0, 1);
		}
		assertEquals(purchasePojo.getTotalCost(), otherPojo.getTotalCost());
	}
	
	@Test
	public void testGetAllPurchase() {
		
		
		BeanUtils.copyProperties(purchasePojo, purchaseEntity);
		purchaseEntity.setShoppingCartItemEntities(new ArrayList<ShoppingCartItemEntity>());
		purchaseEntities.add(purchaseEntity);
		
		try {
			Mockito.when(purchaseDao.findAll()).thenReturn(purchaseEntities);
			purchasePojos = purchaseServiceImp.getAllPurchase();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(0, 1);
		}
		assertEquals(purchasePojos.size(), purchaseEntities.size());
		
	}
	
	@Test
	public void testGetAllPurchaseForOne() {
		BeanUtils.copyProperties(purchasePojo, purchaseEntity);
		purchaseEntity.setShoppingCartItemEntities(new ArrayList<ShoppingCartItemEntity>());
		purchaseEntities.add(purchaseEntity);
		
		try {
			Mockito.when(purchaseDao.findByUserID(anyInt())).thenReturn(purchaseEntities);
			purchasePojos = purchaseServiceImp.getAllPurchaseForOne(purchasePojo.getUserID());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(0, 1);
		}
		assertEquals(purchasePojos.size(), purchaseEntities.size());
		
	}
	
}
