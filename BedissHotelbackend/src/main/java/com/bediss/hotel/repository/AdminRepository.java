package com.bediss.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	
	
	// Trouver un user/administrateur par son username 
	public Admin findByUsername(String username);

}
