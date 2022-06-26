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

import com.cts.model.Admin;
import com.cts.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserServiceImpl uService;
	
	@GetMapping
	public List<Admin> getAdmin(){
		return uService.getAdminList();
	}
	
	@PostMapping
	public Admin addAdmin(@RequestBody Admin admin) {
		return uService.addAdmin(admin);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable int id) {
		return uService.deleteAdmin(id);
	}
	
	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin) {
		return uService.updateAdmin(admin);
	}
	
	
}
