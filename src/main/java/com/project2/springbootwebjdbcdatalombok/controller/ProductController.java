package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProductPojo;
import com.project2.springbootwebjdbcdatalombok.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public List<ProductPojo> getAllProduct() throws ApplicationException{
		return productService.getAllProducts();
	}
}
