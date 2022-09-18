package com.project2.springbootwebjdbcdatalombok.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springbootwebjdbcdatalombok.dao.ProfileDao;
import com.project2.springbootwebjdbcdatalombok.entity.ProductEntity;
import com.project2.springbootwebjdbcdatalombok.entity.ProfileEntity;
import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProductPojo;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;

@Service
public class ProfileServiceImp implements ProfileService {

	@Autowired
	ProfileDao profileDao;
	
	@Override
	public List<ProfilePojo> getAllProfile() throws ApplicationException {
		// TODO Auto-generated method stub
		List<ProfileEntity> profileEntities = profileDao.findAll();
		List<ProfilePojo> profilePojos = new ArrayList<ProfilePojo>();
		for(ProfileEntity ent : profileEntities) {
			ProfilePojo profilePojo = new ProfilePojo();
			profilePojo.setDescription(ent.getDescription());
			profilePojo.setFirstName(ent.getFirstName());
			profilePojo.setIconImg(ent.getIconImg());
			profilePojo.setLastName(ent.getLastName());
			profilePojo.setProfileID(ent.getProfileID());
			profilePojo.setUserID(ent.getUserID());
			profilePojos.add(profilePojo);
		}
		return profilePojos;
	}

	@Override
	public ProfilePojo getOneProfile(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		Optional<ProfileEntity> optional = profileDao.findById(id);
		ProfilePojo profilePojo = null;
		if(optional.isPresent()) {
			profilePojo = new ProfilePojo();
			BeanUtils.copyProperties(optional.get(), profilePojo);
		}
		return profilePojo;
	}

	@Override
	public ProfilePojo createProfile(ProfilePojo profilePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setDescription(profilePojo.getDescription());
		profileEntity.setFirstName(profilePojo.getDescription());
		profileEntity.setIconImg(profilePojo.getIconImg());
		profileEntity.setLastName(profilePojo.getLastName());
		profileEntity.setUserID(profilePojo.getUserID());
		profileDao.saveAndFlush(profileEntity);
		profilePojo.setProfileID(profileEntity.getProfileID());
		return profilePojo;
	}

	@Override
	public ProfilePojo updateProfile(ProfilePojo profilePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		ProfileEntity profileEntity = new ProfileEntity();
		BeanUtils.copyProperties(profilePojo, profileEntity);
		profileDao.save(profileEntity);
		return profilePojo;
	}

	@Override
	public void deleteProfile(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		profileDao.deleteById(id);
	}

}
