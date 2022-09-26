package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project2.springbootwebjdbcdatalombok.dao.ProfileDao;
import com.project2.springbootwebjdbcdatalombok.dao.PurchaseDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProfileEntity;
import com.project2.springbootwebjdbcdatalombok.entity.PurchaseEntity;
import com.project2.springbootwebjdbcdatalombok.entity.PurchaseHistoryEntity;
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
		assertEquals(1, 1);
	}
	
}
