package com.cts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Admin;

@Service
public interface AdminService {
	
	List<Admin> getAdminList();
	Admin addAdmin(Admin admin);
	String deleteAdmin(int id);
	Admin updateAdmin(Admin admin);
	
	
}
