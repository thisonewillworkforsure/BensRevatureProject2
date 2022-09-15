package com.project2.springbootwebjdbcdatalombok.entity;

import javax.persistence.Entity;
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
	private int userID;
	private int typeID;
	private String userName;
	private String userPassword;
	private int statusID;
}
