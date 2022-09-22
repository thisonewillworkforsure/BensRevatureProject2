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
import com.project2.springbootwebjdbcdatalombok.pojo.PurchasePojo;
import com.project2.springbootwebjdbcdatalombok.pojo.ShoppingCartItemPojo;

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
			PurchasePojo purchasePojo = new PurchasePojo();
			ShoppingCartItemPojo shoppingCartItemPojo = new ShoppingCartItemPojo();
			System.out.println(ent.getPurchaseHistoryID() +" " + ent.getPurchaseEntity() + " " + ent.getShoppingCartItemEntity());
			BeanUtils.copyProperties(purchasePojo, ent.getPurchaseEntity());
			BeanUtils.copyProperties(shoppingCartItemPojo, ent.getShoppingCartItemEntity());
			pojo.setPurchasePojo(purchasePojo);
			pojo.setShoppingCartItemPojo(shoppingCartItemPojo);
			pojo.setPurchaseHistoryID(ent.getPurchaseHistoryID());
			pojos.add(pojo);
		}
		return pojos;
	}

	@Override
	public PurchaseHistoryPojo getOnePurchaseHistory(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		List<PurchaseHistoryEntity> entities = purchaseHistoryDao.findByPurchaseHistoryID(id);
		PurchaseHistoryPojo pojo = new PurchaseHistoryPojo();
		for(PurchaseHistoryEntity ent: entities) {
			BeanUtils.copyProperties(ent, pojo);
		}
		return pojo;
	}

	@Override
	public PurchaseHistoryPojo createPurchaseHistory(PurchaseHistoryPojo purchaseHistoryPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		/*PurchaseHistoryEntity purchaseHistoryEntity = new PurchaseHistoryEntity();
		purchaseHistoryEntity.setPurchaseID(purchaseHistoryPojo.getPurchaseID());
		purchaseHistoryEntity.setShoppingID(purchaseHistoryPojo.getShoppingID());
		purchaseHistoryDao.saveAndFlush(purchaseHistoryEntity);
		purchaseHistoryPojo.setPurchaseHistoryID(purchaseHistoryEntity.getPurchaseHistoryID());*/
		return purchaseHistoryPojo;
	}

	@Override
	public PurchaseHistoryPojo updatePurchaseHistory( PurchaseHistoryPojo purchaseHistoryPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		PurchaseHistoryEntity purchaseHistoryEntity = new PurchaseHistoryEntity();
		BeanUtils.copyProperties(purchaseHistoryPojo, purchaseHistoryEntity);
		purchaseHistoryDao.save(purchaseHistoryEntity);
		return purchaseHistoryPojo;
	}

	@Override
	public void deletePurchaseHistory(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		purchaseHistoryDao.deleteById(id);
	}

}
