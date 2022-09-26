package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project2.springbootwebjdbcdatalombok.dao.ProductDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProductEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProductPojo;
import com.project2.springbootwebjdbcdatalombok.service.ProductServiceImp;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImpTest {

	
	@InjectMocks
	private ProductServiceImp productServiceImp;
	
	@Mock
	private ProductDao productDao;
	
	@Mock
	private ProductPojo productPojo;
	
	@Mock
	private ProductPojo otherPojo;
	
	@Mock
	private ProductEntity productEntity;
	
	@Mock
	private List<ProductPojo> productPojos;
	
	@Mock
	private List<ProductEntity> productEntities;
	
	@BeforeEach
	public void beforeEach() {
		
		productPojo = new ProductPojo();
		
		productPojo.setProductCost(100);
		productPojo.setProductDesc("an item");
		productPojo.setProductID(-30);
		productPojo.setProductImg("bla.com");
		productPojo.setProductName("Herb");
		
		otherPojo = new ProductPojo();
		
		otherPojo.setProductCost(100);
		otherPojo.setProductDesc("an item");
		otherPojo.setProductID(-30);
		otherPojo.setProductImg("bla.com");
		otherPojo.setProductName("Herb");
		
		productEntity = new ProductEntity();
	}
	
	@Test
	public void testUpdateProduct() {
		
		BeanUtils.copyProperties(productPojo, productEntity);
		productEntity.setProductName("Ribbon");
		try {
			Mockito.when(productDao.save(any())).thenReturn(productEntity);
			productPojo = productServiceImp.updateProduct(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(productPojo.getProductName(), otherPojo.getProductName());
	}
	
	@Test
	public void testCreateProduct() {
	
		otherPojo.setProductCost(30);
		try {
			Mockito.when(productDao.saveAndFlush(any())).thenReturn(productEntity);
			productPojo = productServiceImp.createProduct(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(productPojo.getProductCost(), otherPojo.getProductCost());
		
	}
	
	@Test
	public void testDeleteProduct() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testGetAllProducts() {
		productEntities = new ArrayList<ProductEntity>();
		productPojos = new ArrayList<ProductPojo>();
		BeanUtils.copyProperties(productPojo, productEntity);
		productEntities.add(productEntity);
		try {
			Mockito.when(productDao.findAll()).thenReturn(productEntities);
			productPojos = productServiceImp.getAllProducts();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		System.out.println(productPojos.size());
		assertEquals(productPojos.size(), productEntities.size());
		
	}
	
	
	@Test
	public void testGetOneProduct() {
		
		try {
			productEntity.setProductID(productPojo.getProductID());
			productEntity.setProductName("SuccessCookie");
			Mockito.when(productDao.findById(productPojo.getProductID())).thenReturn(Optional.of(productEntity));
			productPojo = productServiceImp.getOneProduct(productPojo.getProductID());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		
		assertEquals(productPojo.getProductName(), productEntity.getProductName());
	}
	
}
