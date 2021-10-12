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
		} else {
			return hotelRepository.findByNomContainsOrVilleContains(search, search);
		}
	}

	// trouver un hotel
	public Hotel findClientById(Integer id) {
		return hotelRepository.findById(id).get();

	}

	// ajouter un hotel
	public Hotel add(String nom, String etoiles, String adresse, String telephone, String email, String ville) {
		Hotel c = new Hotel();
		c.setNom(nom);
		c.setEtoiles(etoiles);
		c.setAdresse(adresse);
		c.setTelephone(telephone);
		c.setEmail(email);
		c.setVille(ville);
		hotelRepository.save(c);
		return c;
	}

	// edit-maj du hotel
	public Hotel edit(Integer id, String nom, String etoiles, String adresse, String telephone, String email,
			String ville) {
		Hotel c = hotelRepository.findById(id).get();
		c.setNom(nom);
		c.setEtoiles(etoiles);
		c.setAdresse(adresse);
		c.setTelephone(telephone);
		c.setEmail(email);
		c.setVille(ville);
		hotelRepository.save(c);
		return c;

	}

	// supprimer un hotel
	public void delete(Integer id) {
		hotelRepository.deleteById(id);
	}

	public Hotel findByVille(String ville) {
		try {
			return hotelRepository.findByVille(ville);
		} catch (Exception e) {
			return null;
		}
	}

	private void checkHotel(String nom, String etoiles, String adresse, String telephone, String email, String ville)
			throws Exception {
		if (nom.length() < 2) {
			throw new Exception("Le nom doit être supèrieur à 2 caractères");
		}
		if (etoiles.length() < 0 || etoiles.length() > 2) {
			throw new Exception("Le chiffre doit être entre 0 et 5");
		}
		if (adresse.length() < 2) {
			throw new Exception("L'adresse doit comporter plus de 2 caractères");
		}
		if (telephone.length() < 10 || telephone.length() > 15) {
			throw new Exception("Le telephone doit comporter 10 chiffres avec ou sans espaces ou tirets");
		}
		if (email.length() < 2) {
			throw new Exception("L'email doit comporter plus de 2 caractères");
		}
		if (ville.length() < 2) {
			throw new Exception("La ville doit être supèrieure à 2 caractères");
		}
	}

}
