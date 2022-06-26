package com.cts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Users;

@Service
public interface UsersService {

	List<Users> getUsersList();
	Users addUsers(Users users);
	String deleteUsers(int id);
	Users updateUsers(Users users);
	
}
