package com.project2.springbootwebjdbcdatalombok.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPojo {
	
	private int userID;
	private int typeID;
	private String userName;
	private String userPassword;
	private int statusID;
}

