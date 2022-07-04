package com.cts.authorization.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.User;
import com.cts.authorization.repository.UsersRepository;
import com.cts.authorization.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UsersRepository uRepo;


	@Override
	public List<User> getUsersList() {
		return uRepo.findAll();
	}

	@Override
	public User addUsers(User user) {
		uRepo.save(user);
		return user;
	}

	@Override
	public String deleteUsers(int id) {
		User use=uRepo.findById(id).get();
		uRepo.delete(use);
		return "User Deleted !";
	}

	@Override
	public User updateUsers(User users) {
		Optional<User> op=uRepo.findById(users.getId());
		if(!op.isPresent()) {
			throw new RuntimeException("User with id "+ users.getId()+ " not exist!");
		}
		uRepo.saveAndFlush(users);
		return users;
	}
	
	
	
	
}
