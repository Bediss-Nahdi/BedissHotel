package com.bediss.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Client;



@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

	Iterable<Client> findByNomCompletContainsOrEmailContains(String search, String search2);
	
	Client findByEmail(String email);

}
