package com.cts.authorization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.authorization.model.User;

@Service
public interface UserService {
	
	List<User> getUsersList();
	User addUsers(User user);
	String deleteUsers(int id);
	User updateUsers(User user);
	
}
