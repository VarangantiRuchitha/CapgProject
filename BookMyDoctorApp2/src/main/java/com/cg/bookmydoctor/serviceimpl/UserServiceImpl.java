package com.cg.bookmydoctor.serviceimpl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.service.IUserService;
import com.cg.bookmydoctor.util.AllConstants;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public User addUser(User user) throws UserException, ValidateUserException{
		validateUser(user);
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(userDb.isPresent()) {
			throw new UserException("User already exists with ID : " +user.getUserId());
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(!userDb.isPresent()) {
			throw new UserException(" User doesn't exists with ID : " +user.getUserId());
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User removeUser(User user) throws UserException{
		User user1 = user;
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(!userDb.isPresent()) {
			throw new UserException(" User with ID : " +user.getUserId()+" doesn't exist to delete");
		} else {
			userDao.deleteById(user.getUserId());
		}
		return user1;	
	}

	@Override
	public User getUser(User user) throws UserException {
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(userDb.isPresent()) {
			return userDb.get();
		}else {
			throw new UserException(" User doesn't exist with Id : " +user.getUserId());
		} 
	}
	
	public boolean validateUser(User user) throws ValidateUserException {
		if (!user.getUserName().matches(AllConstants.USERNAME_PATTERN)) {
			throw new ValidateUserException(AllConstants.USER_CANNOT_BE_EMPTY);
		}
		if (!user.getPassword().matches(AllConstants.PASSWORD_PATTERN)) {
			throw new ValidateUserException(AllConstants.PASSWORD_NOT_STRONG);
		}
		if (!user.getRole().matches("Admin") && !user.getRole().matches("Doctor") && !user.getRole().matches("Patient")) {
			throw new ValidateUserException(AllConstants.ROLE_INVALID);
		}
		return true;
	}

}
