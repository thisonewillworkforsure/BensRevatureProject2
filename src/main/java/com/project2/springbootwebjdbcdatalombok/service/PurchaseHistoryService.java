package com.project2.springbootwebjdbcdatalombok.service;

import java.awt.PrintGraphics;
import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchaseHistoryPojo;

public interface PurchaseHistoryService {
	
	List<PurchaseHistoryPojo> getAllPurchaseHistory() throws ApplicationException;
	
	List<PurchaseHistoryPojo> getOnePurchaseHistory() throws ApplicationException;
	
	PurchaseHistoryPojo createPurchaseHistory() throws ApplicationException;
	
	PurchaseHistoryPojo updatePurchaseHistory() throws ApplicationException;
	
	void deletePurchaseHistory(int id) throws ApplicationException;
	
}
