package com.cg.bookmydoctor.service;

import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;

public interface IUserService {
	
	public User addUser(User user) throws UserException, ValidateUserException;
	public User updateUser(User user) throws UserException;
	public User removeUser(User user) throws UserException;
	public User getUser(User user)throws UserException;

}