package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.ProductDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProductEntity;
import com.project2.springbootwebjdbcdatalombok.entity.UsersEntity;
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
		Optional<ProductEntity> optional = productDao.findById(id);
		ProductPojo productPojo = null;
		if(optional.isPresent()) {
			productPojo = new ProductPojo();
			BeanUtils.copyProperties(optional.get(), productPojo);
		}
		return productPojo;
	}

	@Override
	public ProductPojo createProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		try {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductDesc(productPojo.getProductDesc());
			productEntity.setProductImg(productPojo.getProductImg());
			productEntity.setProductCost(productPojo.getProductCost());
			productEntity.setProductName(productPojo.getProductName());
			productDao.saveAndFlush(productEntity);
			System.out.println(productEntity);
			productPojo.setProductID(productEntity.getProductID());
			return productPojo;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productPojo, productEntity);
		productDao.save(productEntity);
		return productPojo;
	}

	@Override
	public void deleteProduct(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		productDao.deleteById(id);
	}

	

}
