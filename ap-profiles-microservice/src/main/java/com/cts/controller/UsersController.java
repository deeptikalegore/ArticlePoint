
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

import com.cts.feign.AuthorisingClient;
import com.cts.model.Users;

@RestController
@RequestMapping(value="/portal")
public class UsersController {

	@Autowired
	private AuthorisingClient auth;

	@GetMapping("/users")
	public List<Users> getUsers() {
		return auth.getUsers();
	}

	@PostMapping("/adduser")
	public Users addUsers(@RequestBody Users users) {
		return auth.addUsers(users);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUsers(@PathVariable int id) {
		return auth.deleteUsers(id);
	}

	@PutMapping
	public Users updateUsers(@RequestBody Users users) {
		return auth.updateUsers(users);
	}

}
