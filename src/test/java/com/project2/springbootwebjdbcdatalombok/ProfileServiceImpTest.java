package com.project2.springbootwebjdbcdatalombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

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
	ProfileDao profileDao;
	
	@BeforeEach
	public void beforeEach() {
		
		profilePojo = new ProfilePojo();
		profilePojo.setFirstName("hi"); //testing this
		profilePojo.setDescription("mister");
		profilePojo.setIconImg("bla.com");
		profilePojo.setLastName("there");
		profilePojo.setUserID(20);
		profilePojo.setProfileID(0);
		
		otherPojo = new ProfilePojo();
		otherPojo.setFirstName("why"); //testing this
		otherPojo.setDescription("mister");
		otherPojo.setIconImg("bla.com");
		otherPojo.setLastName("there");
		otherPojo.setUserID(20);
		otherPojo.setProfileID(0);
		
		profileEntity = new ProfileEntity();
	}
	
	
	@Test
	public void testCreateProfile() {
		
		BeanUtils.copyProperties(profilePojo, profileEntity);
		
		try {
			Mockito.when(profileDao.save(any())).thenReturn(profileEntity);
			profilePojo = profileServiceImp.updateProfile(otherPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			assertEquals(1, 0);
		}
		assertEquals(profilePojo.getFirstName(), otherPojo.getFirstName());
	}
	
}
