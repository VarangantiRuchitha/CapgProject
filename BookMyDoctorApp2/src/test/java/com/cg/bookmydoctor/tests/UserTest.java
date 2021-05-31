package com.cg.bookmydoctor.tests;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.serviceimpl.UserServiceImpl;

public class UserTest extends BookMyDoctorAppApplicationTests { 
	
	
	@Autowired
	UserServiceImpl usi;
	
	@Before
	public void setUp() {
		usi = new UserServiceImpl();
		List<User> userList = new ArrayList<User>();
		User u = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
		User u1 = new User(2, "Raghu", "Raghu@2702", "Patient");
		userList.add(u);
		userList.add(u1);	
	}
	
	@Test
	void testUserServiceImpl() {
		assertTrue(usi instanceof UserServiceImpl);
	}
	
	@Test
    void testAddUser() throws UserException, ValidateUserException{
		User u = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
		u = usi.addUser(u);
		assertEquals(u.getUserId(), 1);
		
		User u1 = new User(2, "Raghu", "Raghu@2702", "Patient");
		u1 = usi.addUser(u1);
		assertEquals(u1.getUserId(), 2);
	}
	
	@Test
	void testUpdateUser() throws ValidateUserException, UserException {
		User u = new User(1, "Gojo", "Satoru@1", "Admin");
		u = usi.updateUser(u);
		assertEquals(u.getUserId(), 1);
		
		User u1 = new User(2, "Sukuna", "Satoru@1", "Admin");
		u1 = usi.updateUser(u1);
		assertEquals(u1.getUserId(), 2);		
	}
	
	@Test
	void testRemoveUser() throws ValidateUserException, UserException {
		User u = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
		User u1 = usi.removeUser(u);
		assertEquals(u.getUserId(), u1.getUserId());	
	}
	
	@Test
	void testGetUser() throws UserException {
		User u = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
		User u1 = usi.getUser(u);
		assertEquals(u.getUserId(),1);
	}
	
	@After
	public void setDown() {
		usi = null;
	}
}
