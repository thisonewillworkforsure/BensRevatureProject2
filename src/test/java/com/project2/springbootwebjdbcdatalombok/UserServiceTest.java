package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.project2.springbootwebjdbcdatalombok.dao.ProfileDao;
import com.project2.springbootwebjdbcdatalombok.dao.UserDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProfileEntity;
import com.project2.springbootwebjdbcdatalombok.entity.UsersEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;
import com.project2.springbootwebjdbcdatalombok.pojo.UserPojo;
import com.project2.springbootwebjdbcdatalombok.service.ProfileServiceImp;
import com.project2.springbootwebjdbcdatalombok.service.UserServiceImp;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImp userServiceImp;
	
	@Mock
	private UserDao userDao;
	
	@Mock
	private ProfileServiceImp profileServiceImp;
	
	@Mock 
	private UserPojo userPojo;
	
	@Mock
	private UserPojo otherPojo;
	
	@Mock
	private ProfilePojo profilePojo;
	
	@Mock
	private ProfilePojo otherProfilePojo;
	
	@Mock
	private UsersEntity usersEntity;
	
	@Mock
	private List<UserPojo> userPojos;
	
	@Mock
	private List<UsersEntity> usersEntities;
	
	@BeforeEach
	public void beforeEach() {
		userPojo = new UserPojo();
		
		userPojo.setStatusID(1);
		userPojo.setTypeID(2);
		userPojo.setUserID(-500);
		userPojo.setUserName("john");
		userPojo.setUserName("smith");
		
		otherPojo = new UserPojo();
		
		otherPojo.setStatusID(1);
		otherPojo.setTypeID(2);
		otherPojo.setUserID(-500);
		otherPojo.setUserName("john");
		otherPojo.setUserName("smith");
		
		usersEntity = new UsersEntity();
		
		userPojos = new ArrayList<UserPojo>();
		
		usersEntities = new ArrayList<UsersEntity>();
		
		profilePojo = new ProfilePojo();
		
		otherProfilePojo = new ProfilePojo();
	}
	
	@Test
	public void testUpdateUser() {
		
		otherPojo.setUserPassword("ItsMe!");
		try {
			Mockito.when(userDao.save(any())).thenReturn(usersEntity);
			userPojo = userServiceImp.updateUser(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(userPojo.getUserPassword(),otherPojo.getUserPassword());
		
	}
	
	@Test
	public void getOneUser() {
		
		try {
			BeanUtils.copyProperties(userPojo, usersEntity);
			usersEntities.add(usersEntity);
			userPojo.setUserID(-1000);
			Mockito.when(userDao.findByUserNameAndUserPassword(userPojo.getUserName(),userPojo.getUserPassword())).thenReturn(usersEntities);
			userPojo = userServiceImp.getOneUser(userPojo.getUserName(),userPojo.getUserPassword());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		
		assertEquals(userPojo.getUserID(),usersEntities.get(0).getUserID());
	}
	
	@Test
	public void getAllUser() {
		
		try {
			BeanUtils.copyProperties(userPojo, usersEntity);
			usersEntities.add(usersEntity);
			Mockito.when(userDao.findAll()).thenReturn(usersEntities);
			userPojos = userServiceImp.getAllUsers();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		
		assertEquals(userPojos.size(),usersEntities.size());
		
	}
	
	@Test
	public void testCreateUser() {
		
		//Setting these to two because of how the function works, 2 means customer! so a profile will be made by default
		userPojo.setTypeID(2);
		otherPojo.setTypeID(2);
		
		profilePojo.setDescription("profile");
		profilePojo.setFirstName("John");
		profilePojo.setIconImg("bla.com");
		profilePojo.setLastName("Smith");
		profilePojo.setProfileID(-500);
		profilePojo.setUserID(-500);
		
		BeanUtils.copyProperties(profilePojo, otherProfilePojo);
		
		otherProfilePojo.setDescription("the true answer!");
		
		
		
		otherPojo.setUserPassword("whoathere");
		try {
			Mockito.when(userDao.saveAndFlush(any())).thenReturn(usersEntity);
			Mockito.when(profileServiceImp.createProfile(any())).thenReturn(otherProfilePojo);
			userPojo = userServiceImp.createUser(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			verify(profileServiceImp, times(1)).createProfile(any());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(userPojo.getUserPassword(), otherPojo.getUserPassword());
		
	}
	
	
	@Test
	public void testCreateGuestOrAdmin() {
		
		//Setting these to two because of how the function works, 2 means customer! so a profile will be made by default
		userPojo.setTypeID(1);
		otherPojo.setTypeID(1);	
		
		otherPojo.setUserPassword("whoathere");
		try {
			Mockito.when(userDao.saveAndFlush(any())).thenReturn(usersEntity);
			userPojo = userServiceImp.createUser(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(userPojo.getUserPassword(), otherPojo.getUserPassword());
		
	}
	
	

}
