package com.project2.springbootwebjdbcdatalombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.project2.springbootwebjdbcdatalombok.pojo.UserPojo;
import com.project2.springbootwebjdbcdatalombok.service.UserService;

import lombok.Getter;

//if you need data validation it needs @validated!


@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<UserPojo> getAllUsers() throws ApplicationException{
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/user")
	public UserPojo getOneUser(String userName, String passWord) throws ApplicationException {
		return userService.getOneUser(userName, passWord);
	}
	
	@PostMapping("")
	public UserPojo createUser(@Validated @RequestBody UserPojo userPojo) throws ApplicationException{
		System.out.println("this is in the CONTROLLER! : " + userPojo);
		userPojo = userService.createUser(userPojo);
		return userPojo;
	}
	
	@PutMapping("")
	public UserPojo updateUser(@RequestBody UserPojo userPojo) throws ApplicationException{
		
		return userService.updateUser(userPojo);
	}
	
	@DeleteMapping("/{bid}")
	public void deleteUser(@PathVariable("bid") int id) throws ApplicationException {
		userService.deleteUser(id);
	}
	
	
	@PostMapping("/test")
	public UserPojo createUser(int s, int t, String u, String p) throws ApplicationException{
		UserPojo userPojo = new UserPojo();
		userPojo.setStatusID(s);
		userPojo.setTypeID(t);
		userPojo.setUserName(u);
		userPojo.setUserPassword(p);
		userPojo = userService.createUser(userPojo);
		return userPojo;
	}
	
}
