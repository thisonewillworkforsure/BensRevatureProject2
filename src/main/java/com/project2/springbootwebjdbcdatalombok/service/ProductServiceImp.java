package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.ProductDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProductEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProductPojo;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<ProductPojo> getAllProducts() throws ApplicationException {
		// TODO Auto-generated method stub
		List<ProductEntity> productEntities = productDao.findAll();
		List<ProductPojo> productPojos = new ArrayList<ProductPojo>();
		for(ProductEntity ent : productEntities) {
			ProductPojo pojo = new ProductPojo();
			BeanUtils.copyProperties(ent, pojo);
			productPojos.add(pojo);
		}
		return productPojos;
	}

	@Override
	public ProductPojo getOneProduct(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPojo createProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

}
