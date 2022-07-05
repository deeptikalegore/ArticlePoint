package com.cts.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.exception.AuthorizationException;
import com.cts.model.JwtRequest;
import com.cts.model.Users;

@FeignClient(name = "Authorizatiion-Microservice", url = "${auth.URL}")

public interface AuthorisingClient {
    
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws AuthorizationException;

	@PostMapping(value = "/authorize")
	public boolean authorizeTheRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
	@GetMapping("users")
	public List<Users> getUsers();
	
	@PostMapping("adduser")
	public Users addUsers(@RequestBody Users users);

	@DeleteMapping("delete/{id}")
	public String deleteUsers(@PathVariable int id);
	
	@PutMapping
	public Users updateUsers(@RequestBody Users user);
	
	
}