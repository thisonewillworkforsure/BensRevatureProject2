package com.project2.springbootwebjdbcdatalombok.service;

import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProductPojo;

public interface ProductService {

	List<ProductPojo> getAllProducts() throws ApplicationException;
	
	ProductPojo getOneProduct(int id) throws ApplicationException;
	
	ProductPojo createProduct(ProductPojo productPojo) throws ApplicationException;
	
	ProductPojo updateProduct(ProductPojo productPojo) throws ApplicationException;
	
	void deleteProduct(int id) throws ApplicationException;
}
