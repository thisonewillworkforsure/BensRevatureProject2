package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.PurchaseHistoryEntity;
import com.project2.springbootwebjdbcdatalombok.pojo.PurchaseHistoryPojo;

@Repository
public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistoryEntity, Integer> {

	//@PersistenceContext EntityManager entityManager;
	
	List<PurchaseHistoryEntity> findByPurchaseHistoryID(int id);
	
	//@Query(value = "SELECT purchase.total_cost AS totalcost,purchase.purchase_date AS purchasedate, STRING_AGG(shopping_cart_item.quantity || ' ' ||product.product_name,',') AS purchases FROM purchase INNER JOIN purchase_history ON purchase_history.purchase_id = purchase.purchase_id INNER JOIN shopping_cart_item ON shopping_cart_item.shopping_id = purchase_history.shopping_id INNER JOIN product ON product.product_id = shopping_cart_item.product_id GROUP BY purchase.purchase_id HAVING purchase.user_id = 1;"
		//	,nativeQuery = true) List<HistoryPojo> findByUserID(int userID);
	
	
	/*@SuppressWarnings("unchecked")
	public static List<HistoryPojo> getHistory(int userID){
		EntityManager entityManager = new EntityManager();
		Query query = (Query) entityManager.createNativeQuery(
				"SELECT purchase.total_cost AS totalcost,purchase.purchase_date AS purchasedate, STRING_AGG(shopping_cart_item.quantity || ' ' ||product.product_name,',') AS purchases FROM purchase INNER JOIN purchase_history ON purchase_history.purchase_id = purchase.purchase_id INNER JOIN shopping_cart_item ON shopping_cart_item.shopping_id = purchase_history.shopping_id INNER JOIN product ON product.product_id = shopping_cart_item.product_id GROUP BY purchase.purchase_id HAVING purchase.user_id = ?1;"
				);
		((javax.persistence.Query) query).setParameter(1,userID);
		//@SuppressWarnings("unchecked")
		return  ((javax.persistence.Query) query).getResultList();
	}*/
	
	

}
