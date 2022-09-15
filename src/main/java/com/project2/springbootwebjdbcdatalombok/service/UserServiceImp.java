package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.UserDao;
import com.project2.springbootwebjdbcdatalombok.entity.UsersEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.UserPojo;

@Service
public class UserServiceImp implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	
	
	//UserDao Reference Variable
	@Autowired
	UserDao userDao;
	
	@Override
	public List<UserPojo> getAllUsers() throws ApplicationException {
		// TODO Auto-generated method stub
		logger.info("Invoking getAllUsers in the service layer");
		List<UsersEntity> allUsersEntities = userDao.findAll();
		List<UserPojo> allUserPojos = new ArrayList<UserPojo>();
		allUsersEntities.forEach((user)->{
			allUserPojos.add(new UserPojo(user.getUserID(),user.getTypeID(),user.getUserName(),user.getUserPassword(),user.getStatusID()));
		});
		return allUserPojos;
	
	}

	@Override
	public UserPojo getOneUser(String userName, String passWord) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo createUser(UserPojo userPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userID) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

}
