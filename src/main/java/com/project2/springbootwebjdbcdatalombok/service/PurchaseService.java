package com.project2.springbootwebjdbcdatalombok.service;

import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchasePojo;

public interface PurchaseService {

	List<PurchasePojo> getAllPurchase() throws ApplicationException;
	
	List<PurchasePojo> getAllPurchaseForOne(int user_id) throws ApplicationException;
	
	List<PurchasePojo> getOnePurchase(int id) throws ApplicationException;
	
	PurchasePojo createPurchase(PurchasePojo purchasePojo) throws ApplicationException;
	
	PurchasePojo updatePurchase(PurchasePojo purchasePojo) throws ApplicationException;
	
	void deletePurchase(int id) throws ApplicationException;
}
