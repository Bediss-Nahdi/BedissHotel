package com.bediss.hotel.apricontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bediss.hotel.entities.Admin;
import com.bediss.hotel.repository.AdminRepository;


@RestController
@RequestMapping(value="/api/login")
public class AdminController {

	@Autowired
	AdminRepository adminRespository;
	
	

	// trouver un user via son nom et mdp
	@PostMapping(path="", produces = "application/json")
	ResponseEntity<Admin> checkLogin(@RequestBody Admin admin) {
		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		try {
			Admin a = adminRespository.findByUsername(admin.getUsername());
			
//			if(encoder.matches(a.getPassword(),admin.getPassword()))  
			a.setPassword("");
			
			return ResponseEntity.ok().body(a);
			
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	



}
