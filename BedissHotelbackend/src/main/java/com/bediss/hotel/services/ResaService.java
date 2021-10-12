package com.bediss.hotel.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bediss.hotel.entities.Client;
import com.bediss.hotel.entities.Hotel;
import com.bediss.hotel.entities.Resa;
import com.bediss.hotel.repository.ClientRepository;
import com.bediss.hotel.repository.HotelRepository;
import com.bediss.hotel.repository.ResaRepository;

@Service
public class ResaService {

	@Autowired
	ResaRepository resaRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	HotelRepository hotelRepository;

	// trouver toutes les réservations
	public Iterable<Resa> findAllResa(String search) {
		if (search == null || search.length() > 0) {
			return resaRepository.findAll();
		} else {
			return resaRepository.findByClientContains(search);
		}
	}

	// trouver une réservation
	public Resa findClientById(Integer id) {
		return resaRepository.findById(id).get();
	}

	// ajouter une réservation
	public Resa add(Date dateDebut, Date dateFin, Integer client, Integer hotel, int numeroChambre) {
		Resa resa = new Resa();
		resa.setDateDebut(dateDebut);
		resa.setDateFin(dateFin);
		
		
		Client c = clientRepository.findById(client).get();
		c.setId(client);
		resa.setClient(c);
		
		Hotel hot = hotelRepository.findById(hotel).get();
		hot.setId(hotel);
		resa.setHotel(hot);;

		resa.setNumeroChambre(numeroChambre);
		
		resaRepository.save(resa);

		return resa;
	}

	// edit-maj d'une réservation
	public Resa edit(Integer id, Date dateDebut, Date dateFin, Integer client, Integer hotel, int numeroChambre) {
		Resa resa = resaRepository.findById(id).get();
		
		resa.setDateDebut(dateDebut);
		resa.setDateFin(dateFin);
		
		
		Client c = clientRepository.findById(client).get();
		c.setId(client);
		resa.setClient(c);
		
		Hotel hot = hotelRepository.findById(hotel).get();
		hot.setId(hotel);
		resa.setHotel(hot);;

		resa.setNumeroChambre(numeroChambre);
		
		resaRepository.save(resa);

		return resa;
	}

	// supprimer une réservation
	public void delete(Integer id) {
		resaRepository.deleteById(id);
	}

	public Resa findByClient(String nomClient) {
		try {
			return resaRepository.findByClient(nomClient).get();
		} catch (Exception e) {
			return null;
		}
	}

}
