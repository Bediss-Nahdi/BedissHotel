package com.bediss.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bediss.hotel.entities.Hotel;
import com.bediss.hotel.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	
	// trouver tous les hotels
	public Iterable<Hotel> findAllHotel(String search) {
		if (search == null || search.length() > 0) {
			return hotelRepository.findAll();
		}else {
			return hotelRepository.findByNomContainsOrVilleContains(search, search);
		}
    }
		
		
		// trouver un hotel
		public Hotel findClientById(Integer id) {
			return hotelRepository.findById(id).get();
	        
	    }	
				
		// ajouter un hotel
		public Hotel add(String nom, String email, String telephone, String adresse) {
			Hotel c = new Hotel();
			c.setNom(nom);
			c.setEmail(email);
			c.setTelephone(telephone);
			c.setAdresse(adresse);
			hotelRepository.save(c);
			return c;  
	    }   
	    
		
		
		// edit-maj du  hotel
		public Hotel edit(Integer id, String nom, String email, String telephone, String adresse ) {
			Hotel c = hotelRepository.findById(id).get();
			c.setNom(nom);
			c.setEmail(email);
			c.setTelephone(telephone);
			c.setAdresse(adresse);
			hotelRepository.save(c);
			return c;
	        
	    }
		
		//supprimer un hotel
		public void delete(Integer id) {
			hotelRepository.deleteById(id);
	    }
		

}
