package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.PurchaseHistoryDao;
import com.project2.springbootwebjdbcdatalombok.entity.PurchaseHistoryEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchaseHistoryPojo;

@Service
public class PurchaseHistoryServiceImp implements PurchaseHistoryService {

	@Autowired
	private PurchaseHistoryDao purchaseHistoryDao;
	
	@Override
	public List<PurchaseHistoryPojo> getAllPurchaseHistory() throws ApplicationException {
		// TODO Auto-generated method stub
		List<PurchaseHistoryEntity> entities = purchaseHistoryDao.findAll();
		List<PurchaseHistoryPojo> pojos = new ArrayList<PurchaseHistoryPojo>();
		for(PurchaseHistoryEntity ent: entities) {
			PurchaseHistoryPojo pojo = new PurchaseHistoryPojo();
			BeanUtils.copyProperties(ent, pojo);
			pojos.add(pojo);
		}
		return pojos;
	}

	@Override
	public List<PurchaseHistoryPojo> getOnePurchaseHistory() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseHistoryPojo createPurchaseHistory() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseHistoryPojo updatePurchaseHistory() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePurchaseHistory(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

}
