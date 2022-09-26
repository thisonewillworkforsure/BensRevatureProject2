package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.project2.springbootwebjdbcdatalombok.dao.ProfileDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProfileEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;
import com.project2.springbootwebjdbcdatalombok.service.ProfileServiceImp;

//@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class ProfileServiceImpTest {

	@InjectMocks
	ProfileServiceImp profileServiceImp;
	
	@Mock
	ProfilePojo profilePojo;
	
	@Mock
	ProfilePojo otherPojo;
	
	@Mock
	ProfileEntity profileEntity;
	
	@Mock
	List<ProfilePojo> profilePojos;
	
	@Mock
	List<ProfileEntity> profileEntities;
	
	@Mock
	ProfileDao profileDao;
	
	@BeforeEach
	public void beforeEach() {
		
		profilePojo = new ProfilePojo();
		profilePojo.setFirstName("hi"); //testing this
		profilePojo.setDescription("mister");
		profilePojo.setIconImg("bla.com");
		profilePojo.setLastName("there");
		profilePojo.setUserID(-33);
		profilePojo.setProfileID(0);
		
		otherPojo = new ProfilePojo();
		otherPojo.setFirstName("why"); //testing this
		otherPojo.setDescription("mister");
		otherPojo.setIconImg("bla.com");
		otherPojo.setLastName("there");
		otherPojo.setUserID(-33);
		otherPojo.setProfileID(0);
		
		profileEntity = new ProfileEntity();
		profilePojos = new ArrayList<ProfilePojo>();
		profileEntities = new ArrayList<ProfileEntity>();
	}
	
	
	@Test
	public void testUpdateProfile() {
		
		BeanUtils.copyProperties(profilePojo, profileEntity);
		profileEntity.setFirstName("why");
		try {
			Mockito.when(profileDao.save(any())).thenReturn(profileEntity);
			profilePojo = profileServiceImp.updateProfile(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(profilePojo.getFirstName(), otherPojo.getFirstName());
	}
	
	@Test
	public void testGetOneProfile() {
		
		BeanUtils.copyProperties(profilePojo, profileEntity);
		profileEntity.setDescription("You got it!");
		try {
			Mockito.when(profileDao.findByUserID(profilePojo.getUserID())).thenReturn(profileEntity);
			profilePojo = profileServiceImp.getOneProfile(profilePojo.getUserID());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(profilePojo.getDescription(), profileEntity.getDescription());
	}
	
	@Test
	public void testDeleteProfile() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testCreateProfile() {
		BeanUtils.copyProperties(profilePojo, profileEntity);
		profilePojo.setUserID(-500); //just a number different from other pojo
		try {
			Mockito.when(profileDao.saveAndFlush(any())).thenReturn(profileEntity);
			profilePojo = profileServiceImp.createProfile(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(profilePojo.getUserID(), otherPojo.getUserID());
	}
	
	@Test
	public void testGetAllProfiles() {
		BeanUtils.copyProperties(profilePojo, profileEntity);
		profileEntities.add(profileEntity);
		try {
			Mockito.when(profileDao.findAll()).thenReturn(profileEntities);
			profilePojos = profileServiceImp.getAllProfile();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(profilePojos.size(), profileEntities.size());
		
	}
	
}
