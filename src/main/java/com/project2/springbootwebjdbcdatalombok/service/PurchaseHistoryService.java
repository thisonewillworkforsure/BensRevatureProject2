package com.project2.springbootwebjdbcdatalombok.service;

import java.awt.PrintGraphics;
import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;

import com.project2.springbootwebjdbcdatalombok.pojo.PurchaseHistoryPojo;

public interface PurchaseHistoryService {
	
	List<PurchaseHistoryPojo> getAllPurchaseHistory() throws ApplicationException;
	
	PurchaseHistoryPojo getOnePurchaseHistory(int id) throws ApplicationException;
	
	PurchaseHistoryPojo createPurchaseHistory(PurchaseHistoryPojo purchaseHistoryPojo) throws ApplicationException;
	
	PurchaseHistoryPojo updatePurchaseHistory(PurchaseHistoryPojo purchaseHistoryPojo) throws ApplicationException;
	
	void deletePurchaseHistory(int id) throws ApplicationException;
	
	
	
}
