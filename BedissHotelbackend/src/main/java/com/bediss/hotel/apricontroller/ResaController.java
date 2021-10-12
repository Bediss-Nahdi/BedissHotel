package com.bediss.hotel.apricontroller;

import java.net.URI;
import java.util.List;

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
import com.bediss.hotel.entities.Resa;
import com.bediss.hotel.services.ResaService;

@RestController
@RequestMapping(value="/api")

public class ResaController {
	
	@Autowired
	ResaService resaService;
	
	// crud : ajout , update , delete , getall , get

	// trouver tous les Resa

	@GetMapping(path = "", produces = "application/json")
	public Iterable<Resa> getAllResa(HttpServletRequest request) {
		return resaService.findAllResa(request.getParameter("search"));
	}

	// trouver un client
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Resa> findClientById(@PathVariable("id")  Integer id) {
		try {
			Resa c = resaService.findClientById(id);
			return ResponseEntity.ok().body(c);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	// ajouter un client
	@PostMapping(path = "", produces = "application/json")
	public ResponseEntity<Resa> add(@RequestBody  Resa resa) {
		
		try {
			Resa c = resaService.add(resa.getDateDebut(), resa.getDateFin(),resa.getClient().getId(),resa.getHotel().getId(), resa.getNumeroChambre());
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
	public ResponseEntity<Resa> edit(@RequestBody  Resa resa, @PathVariable("id") Integer id ) {
		try {
			Resa c = resaService.edit(id, resa.getDateDebut(), resa.getDateFin(),resa.getClient().getId(),resa.getHotel().getId(), resa.getNumeroChambre());
			return ResponseEntity.ok().body(c);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// supprimer un client
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		try {
			resaService.delete(id);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	

}
