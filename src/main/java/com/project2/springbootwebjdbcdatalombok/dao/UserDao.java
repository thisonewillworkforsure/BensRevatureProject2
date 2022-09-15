package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.UsersEntity;

//Repository annotation is used to indicate that the class provides
//the mechanism for CRUD operations on objects
@Repository
public interface UserDao extends JpaRepository<UsersEntity, Integer> {

	// if you want to work with cutomized queries(other than the crud queries),  write finder methods
		// SELECT * from book_details WHERE book_genre='Fiction';
	List<UsersEntity> findByUserNameAndUserPassword(String userName, String Password);
}
