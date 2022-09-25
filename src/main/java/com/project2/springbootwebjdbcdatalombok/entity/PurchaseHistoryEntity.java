package com.project2.springbootwebjdbcdatalombok.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@SqlResultSetMapping(name="historyResult", classes = {
@ConstructorResult(targetClass = HistoryPojo.class, 
columns = {@ColumnResult(name="totalcost"), @ColumnResult(name="purchasedate"),@ColumnResult(name = "purchases")})
})
*/

@NoArgsConstructor
@AllArgsConstructor
@Data





@Entity
@Table(name = "purchase_history")
public class PurchaseHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_history_id")
	private int purchaseHistoryID;
	
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id")
	PurchaseEntity purchaseEntity;
	
	@OneToOne
	@JoinColumn(name = "shopping_id")
	ShoppingCartItemEntity shoppingCartItemEntity;
	
}
