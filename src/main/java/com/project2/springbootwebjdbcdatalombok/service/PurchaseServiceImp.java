package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.PurchaseDao;
import com.project2.springbootwebjdbcdatalombok.entity.PurchaseEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchasePojo;

@Service
public class PurchaseServiceImp implements PurchaseService {

	@Autowired
	PurchaseDao purchaseDao;
	
	@Override
	public List<PurchasePojo> getAllPurchase() throws ApplicationException {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities =  purchaseDao.findAll();
		List<PurchasePojo> purchasePojos = new ArrayList<>();
		for(PurchaseEntity ent : purchaseEntities) {
			PurchasePojo purchasePojo = new PurchasePojo();
			BeanUtils.copyProperties(ent, purchasePojo);
			purchasePojos.add(purchasePojo);
		}
		return purchasePojos;
	}

	@Override
	public List<PurchasePojo> getAllPurchaseForOne(int user_id) throws ApplicationException {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities =  purchaseDao.findByUserID(user_id);
		List<PurchasePojo> purchasePojos = new ArrayList<>();
		for(PurchaseEntity ent : purchaseEntities) {
			PurchasePojo purchasePojo = new PurchasePojo();
			BeanUtils.copyProperties(ent, purchasePojo);
			purchasePojos.add(purchasePojo);
		}
		return purchasePojos;
	}

	@Override
	public List<PurchasePojo> getOnePurchase(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchasePojo createPurchase(PurchasePojo purchasePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		PurchaseEntity purchaseEntity = new PurchaseEntity();
		purchaseEntity.setPurchaseDate(purchasePojo.getPurchaseDate());
		purchaseEntity.setTotalCost(purchasePojo.getTotalCost());
		purchaseEntity.setUserID(purchasePojo.getUserID());
		purchaseDao.saveAndFlush(purchaseEntity);
		purchasePojo.setPurchaseID(purchaseEntity.getPurchaseID());
		return purchasePojo;
		
	}

	@Override
	public PurchasePojo updatePurchase(PurchasePojo purchasePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		PurchaseEntity purchaseEntity = new PurchaseEntity();
		BeanUtils.copyProperties(purchasePojo, purchaseEntity);
		purchaseDao.save(purchaseEntity);
		return purchasePojo;
	}

	@Override
	public void deletePurchase(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		purchaseDao.deleteById(id);
	}

}
