package com.project2.springbootwebjdbcdatalombok.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="profile")
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="profile_id")
	private int profileID;
	
	/*
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEntity usersEntity;
	*/
	
	@NotNull
	@Column(name = "user_ID")
	private Integer userID;
	
	@Column(name = "icon_img")
	private String iconImg;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "description")
	private String description;
	
	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users.user_id")*/
	
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user.username")
private User user;
	 * 
	 * 
	 * */
}
