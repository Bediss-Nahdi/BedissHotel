package com.bediss.hotel.apricontroller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bediss.hotel.entities.Hotel;
import com.bediss.hotel.services.HotelService;

@RestController
@RequestMapping(value = "/api/hotel")

public class HotelController {

	@Autowired
	HotelService hotelService;

	// crud : ajout , update , delete , getall , get

	// trouver tous les clients
	
	@GetMapping(path = "", produces = "application/json")
	public Iterable<Hotel> getAllHotel(HttpServletRequest request) {
		return hotelService.findAllHotel(request.getParameter("search"));
	}

	// trouver un client
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Hotel> findClientById(@PathVariable("id")  Integer id) {
		try {
			Hotel c = hotelService.findClientById(id);
			return ResponseEntity.ok().body(c);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	// ajouter un client
	@PostMapping(path = "", produces = "application/json")
	public ResponseEntity<Hotel> add(@RequestBody  Hotel hotel) {
		
		try {
			Hotel c = hotelService.add(hotel.getNom(),hotel.getEmail(), hotel.getTelephone(), hotel.getAdresse());
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(c.getId())
					.toUri();
			return ResponseEntity.created(uri).body(c);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// edit-maj du client
	@PutMapping(path = "", produces = "application/json")
	public ResponseEntity<Hotel> edit(@RequestBody  Hotel hotel, @PathVariable("id") Integer id ) {
		try {
			Hotel c = hotelService.edit(id, hotel.getNom(),hotel.getEmail(), hotel.getTelephone(), hotel.getAdresse());
			return ResponseEntity.ok().body(c);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// supprimer un client
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		try {
			hotelService.delete(id);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
