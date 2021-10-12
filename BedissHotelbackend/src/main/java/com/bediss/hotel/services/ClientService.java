package com.bediss.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bediss.hotel.entities.Client;
import com.bediss.hotel.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	// trouver tous les clients
	public Iterable<Client> findAllClient(String search) {
		if (search == null || search.length() > 0) {
			return clientRepository.findAll();
		}else {
			return clientRepository.findByNomCompletContainsOrEmailContains(search, search);
		}
    }
	
	
	// trouver un client
	public Client findClientById(Integer id) {
		return clientRepository.findById(id).get();
        
    }	
			
	// ajouter un client
	public Client add(String nomComplet, String telephone,String email,String adresse) {
		Client c = new Client();
		c.setNomComplet(nomComplet);
		c.setTelephone(telephone);
		c.setEmail(email);
		c.setAdresse(adresse);
		clientRepository.save(c);
		return c;
        
    }   
    
	// edit-maj du  client
	public Client edit(Integer id, String nomComplet, String telephone,String email,String adresse) {
		Client c = clientRepository.findById(id).get();
		c.setNomComplet(nomComplet);
		c.setTelephone(telephone);
		c.setEmail(email);
		c.setAdresse(adresse);
		clientRepository.save(c);
		return c;
        
    }  
	
	//supprimer un client
	public void delete(Integer id) {
		clientRepository.deleteById(id);
    }
	

}
