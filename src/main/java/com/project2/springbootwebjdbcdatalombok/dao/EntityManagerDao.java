package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.pojo.HistoryPojo;


@SqlResultSetMapping(name = "HistoryResult", classes =
{@ConstructorResult(columns = { @ColumnResult(name="totalcost"),
		@ColumnResult(name="purchasedate"),@ColumnResult(name="purchases") }, targetClass = HistoryPojo.class)})


@Repository
public class EntityManagerDao {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<HistoryPojo> getHistoryWithUser(int userID){
		System.out.println("*******DLGDGJDFGJOIGJIOJODFJJIOGDJIOGJIO");
		Query query = entityManager.createNativeQuery("SELECT * FROM users", HistoryPojo.class);
		return query.getResultList();
	}
}
