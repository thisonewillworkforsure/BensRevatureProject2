package com.project2.springbootwebjdbcdatalombok.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfilePojo {
	
	private int profileID;
	private Integer userID;
	private String iconImg;
	private String firstName;
	private String lastName;
	private String description;
	
}
