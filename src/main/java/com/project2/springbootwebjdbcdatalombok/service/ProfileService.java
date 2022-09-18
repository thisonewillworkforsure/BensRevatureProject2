package com.project2.springbootwebjdbcdatalombok.service;

import java.util.List;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;

public interface ProfileService {
	
	List<ProfilePojo> getAllProfile() throws ApplicationException;
	
	ProfilePojo getOneProfile(int id) throws ApplicationException;
	
	ProfilePojo createProfile(ProfilePojo profilePojo) throws ApplicationException;
	
	ProfilePojo updateProfile(ProfilePojo profilePojo) throws ApplicationException;
	
	void deleteProfile(int id) throws ApplicationException;
}
