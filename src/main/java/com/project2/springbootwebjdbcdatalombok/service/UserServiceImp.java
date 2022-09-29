package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.UserDao;
import com.project2.springbootwebjdbcdatalombok.entity.UsersEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;
import com.project2.springbootwebjdbcdatalombok.pojo.UserPojo;

@Service
public class UserServiceImp implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	
	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProfileService profileService;
	
	@Override
	public List<UserPojo> getAllUsers() throws ApplicationException {
		List<UsersEntity> allUsersEntities = userDao.findAll();
		List<UserPojo> allUserPojos = new ArrayList<UserPojo>();
		allUsersEntities.forEach((user)->{
			allUserPojos.add(new UserPojo(user.getUserID(),user.getTypeID(),user.getUserName(),user.getUserPassword(),user.getStatusID()));
		});
		return allUserPojos;
	
	}

	@Override
	public UserPojo getOneUser(String userName, String passWord) throws ApplicationException {
		List<UsersEntity> usersEntities = userDao.findByUserNameAndUserPassword(userName, passWord);
		if(usersEntities.size() != 0) {
		UserPojo userPojo = new UserPojo();	
		BeanUtils.copyProperties(usersEntities.get(0), userPojo);
		return userPojo;
		}
		return null;
	}

	@Transactional
	@Override
	public UserPojo createUser(UserPojo userPojo) throws ApplicationException {
		try {
			System.out.println(userPojo);
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setStatusID(userPojo.getStatusID());
			usersEntity.setTypeID(userPojo.getTypeID());
			usersEntity.setUserName(userPojo.getUserName());
			usersEntity.setUserPassword(userPojo.getUserPassword());
			userDao.saveAndFlush(usersEntity);
			userPojo.setUserID(usersEntity.getUserID());
			if(userPojo.getTypeID() ==2){//customer ID! making profile
				profileService.createProfile(new ProfilePojo(0,userPojo.getUserID(),"","","",""));
			}
			return userPojo;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw e;
		}
	

	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		UsersEntity usersEntity = new UsersEntity();
		BeanUtils.copyProperties(userPojo, usersEntity);
		userDao.save(usersEntity);
		return userPojo;
	}

	@Override
	public void deleteUser(int userID) throws ApplicationException {
		userDao.deleteById(userID);
	}

}
