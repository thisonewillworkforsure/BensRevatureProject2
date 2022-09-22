package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springbootwebjdbcdatalombok.exception.ApplicationException;
import com.project2.springbootwebjdbcdatalombok.pojo.ProfilePojo;
import com.project2.springbootwebjdbcdatalombok.service.ProfileService;

@CrossOrigin
@RestController
@RequestMapping("api/profiles")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	@GetMapping("")
	public List<ProfilePojo> getAllProfile() throws ApplicationException{
		return profileService.getAllProfile();
	}
	
	@GetMapping("/{pid}")
	public ProfilePojo getOneProfile(@PathVariable("pid") int id) throws ApplicationException{
		return profileService.getOneProfile(id);
	}
	
	@PostMapping("")
	public ProfilePojo createProfile(@RequestBody ProfilePojo profilePojo) throws ApplicationException{
		return profileService.createProfile(profilePojo);
	}
	
	@PutMapping("")
	public ProfilePojo updateProfile(@RequestBody ProfilePojo profilePojo) throws ApplicationException{
		return profileService.updateProfile(profilePojo);
	}
	
	@DeleteMapping("/{pid}")
	public void deleteProfile(@PathVariable("pid") int id) throws ApplicationException {
		profileService.deleteProfile(id);
	}
}
