package com.cts.controller;

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

import com.cts.model.Users;
import com.cts.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UserServiceImpl uService;
	
	@GetMapping
	public List<Users> getUsers(){
		return uService.getUsersList();
	}
	
	@PostMapping
	public Users addUsers(@RequestBody Users users) {
		return uService.addUsers(users);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUsers(@PathVariable int id) {
		return uService.deleteUsers(id);
	}
	
	@PutMapping
	public Users updateUsers(@RequestBody Users users) {
		return uService.updateUsers(users);
	}
	
	
}
