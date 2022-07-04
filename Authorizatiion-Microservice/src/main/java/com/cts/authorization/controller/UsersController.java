package com.cts.authorization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorization.impl.UserServiceImpl;
import com.cts.authorization.model.User;


@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UserServiceImpl uService;
	
	@GetMapping
	public List<User> getUsers(){
		return uService.getUsersList();
	}
	
	@PostMapping
	public User addUsers(@RequestBody User user) {
		return uService.addUsers(user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUsers(@PathVariable int id) {
		return uService.deleteUsers(id);
	}
	
	@PutMapping
	public User updateUsers(@RequestBody User user) {
		return uService.updateUsers(user);
	}
	
	
}
