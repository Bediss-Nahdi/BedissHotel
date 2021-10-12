package com.bediss.hotel.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bediss.hotel.entities.Client;
import com.bediss.hotel.entities.Hotel;
import com.bediss.hotel.entities.Resa;
import com.bediss.hotel.repository.ResaRepository;

@Service
public class ResaService {
	
	@Autowired
	ResaRepository resaRepository;
	
	
	// trouver toutes les réservations
	public Iterable<Resa> findAllResa(String search) {
		if (search == null || search.length() > 0) {
			return resaRepository.findAll();
		}else {
			return resaRepository.findByClientContains(search);
		}
    }
	
	
	// trouver une réservation
	public Resa findClientById(Integer id) {
		return resaRepository.findById(id).get();
    }	
			
	// ajouter une réservation
	public Resa add(Date dateDebut, Date dateFin, Integer client, Integer hotel, int numeroChambre) {
		Resa c = new Resa();
		Client clt = new Client();
		Hotel hot = new Hotel();
		c.setDateDebut(dateDebut);
		c.setDateFin(dateFin);
		c.setNumeroChambre(numeroChambre);
		
		/*ICI*/
		c.setHotel(hot);
		c.setClient(clt);
		
		resaRepository.save(c);
		
		return c;  
    }   
    
	// edit-maj d'une réservation
	public Resa edit(Integer id,Date dateDebut, Date dateFin, Integer client, Integer hotel, int numeroChambre) {
		Resa c = resaRepository.findById(id).get();
		Client clt = new Client();
		Hotel hot = new Hotel();
		c.setDateDebut(dateDebut);
		c.setDateFin(dateFin);
		c.setNumeroChambre(numeroChambre);
		
		/*ICI*/
		c.setHotel(hot);
		c.setClient(clt);
		
		resaRepository.save(c);
		return c;  
    }
	
	//supprimer une réservation
	public void delete(Integer id) {
		resaRepository.deleteById(id);
    }
	

}
