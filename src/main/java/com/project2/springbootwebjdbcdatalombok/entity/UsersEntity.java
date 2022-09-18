package com.project2.springbootwebjdbcdatalombok.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//JPA annotations
@Entity
@Table(name="users")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for the primary key
	
	@Column(name="user_id")
	private int userID;
	
	@Column(name="type_id")
	private int typeID;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="status_id")
	private int statusID;
	
	
	/*@OneToOne(mappedBy = "UsersEntity", fetch = FetchType.LAZY, orphanRemoval = false)
	private ProfileEntity profileEntity = new ProfileEntity();*/
	
    /*@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Authority> listAuthorities = new ArrayList<>();*/
}
