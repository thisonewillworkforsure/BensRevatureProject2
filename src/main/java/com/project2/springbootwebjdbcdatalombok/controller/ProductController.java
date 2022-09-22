package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProductPojo;
import com.project2.springbootwebjdbcdatalombok.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public List<ProductPojo> getAllProduct() throws ApplicationException{
		return productService.getAllProducts();
	}
	
	@GetMapping("/{pid}")
	public ProductPojo getOneProduct(@PathVariable("pid") int id) throws ApplicationException{
		return productService.getOneProduct(id);
	}
	
	@PostMapping("")
	public ProductPojo createProduct(@RequestBody ProductPojo productPojo) throws ApplicationException{
		return productService.createProduct(productPojo);
	}
	
	@PutMapping("")
	public ProductPojo updatePojo(@RequestBody ProductPojo productPojo) throws ApplicationException{
		return productService.updateProduct(productPojo);
	}
	
	@DeleteMapping("/{pid}")
	public void deletePojo(@PathVariable("pid") int id) throws ApplicationException{
		productService.deleteProduct(id);
	}
}
