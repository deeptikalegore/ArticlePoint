package com.cts.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.AdminRepository;
import com.cts.dao.UsersRepository;
import com.cts.model.Admin;
import com.cts.model.Users;
import com.cts.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private AdminRepository aRepo;
	@Autowired
	private UsersRepository uRepo;

	@Override
	public List<Admin> getAdminList() {
		return aRepo.findAll();
	}

	@Override
	public Admin addAdmin(Admin admin) {
		aRepo.save(admin);
		return admin;
	}

	@Override
	public String deleteAdmin(int id) {
		Admin ad=aRepo.findById(id).get();
		aRepo.delete(ad);
		return "Admin Deleted !";
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> op=aRepo.findById(admin.getId());
		if(!op.isPresent()) {
			throw new RuntimeException("Admin with id "+ admin.getId()+ " not exist!");
		}
		aRepo.saveAndFlush(admin);
		return admin;
	}

	@Override
	public List<Users> getUsersList() {
		return uRepo.findAll();
	}

	@Override
	public Users addUsers(Users users) {
		uRepo.save(users);
		return users;
	}

	@Override
	public String deleteUsers(int id) {
		Users use=uRepo.findById(id).get();
		uRepo.delete(use);
		return "User Deleted !";
	}

	@Override
	public Users updateUsers(Users users) {
		Optional<Users> op=uRepo.findById(users.getId());
		if(!op.isPresent()) {
			throw new RuntimeException("User with id "+ users.getId()+ " not exist!");
		}
		uRepo.saveAndFlush(users);
		return users;
	}
	
	
	
	
}
