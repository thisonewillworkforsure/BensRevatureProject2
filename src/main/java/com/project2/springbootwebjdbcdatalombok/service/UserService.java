package com.project2.springbootwebjdbcdatalombok.service;

import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.UserPojo;

public interface UserService {
	
	List<UserPojo> getAllUsers() throws ApplicationException;
	
	UserPojo getOneUser(String userName,String passWord) throws ApplicationException;
	
	UserPojo createUser(UserPojo userPojo) throws ApplicationException;
	
	UserPojo updateUser(UserPojo userPojo) throws ApplicationException;
	
	void deleteUser(int userID) throws ApplicationException;
	
	
}
