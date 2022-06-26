package com.cts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Admin;
import com.cts.model.Users;

@Service
public interface UserService {

	List<Admin> getAdminList();
	Admin addAdmin(Admin admin);
	String deleteAdmin(int id);
	Admin updateAdmin(Admin admin);
	
	List<Users> getUsersList();
	Users addUsers(Users users);
	String deleteUsers(int id);
	Users updateUsers(Users users);
	
}
