package com.project2.springbootwebjdbcdatalombok.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.springbootwebjdbcdatalombok.entity.UsersEntity;

@Repository
public interface UserDao extends JpaRepository<UsersEntity, Integer> {

	List<UsersEntity> findByUserNameAndUserPassword(String userName, String Password);
}
