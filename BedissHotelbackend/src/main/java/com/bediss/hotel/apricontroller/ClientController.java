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

import com.bediss.hotel.entities.Client;
import com.bediss.hotel.services.ClientService;

@RestController
@RequestMapping(value="/api/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	// crud : ajout , update , delete , getall , get

	// trouver tous les clients
	
	@GetMapping(path = "", produces = "application/json")
	public Iterable<Client> getAllClient(HttpServletRequest request) {
		return clientService.findAllClient(request.getParameter("search"));
	}

	// trouver un client
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Client> findClientById(@PathVariable("id")  Integer id) {
		try {
			Client c = clientService.findClientById(id);
			return ResponseEntity.ok().body(c);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		

	}

	// ajouter un client
	@PostMapping(path = "", produces = "application/json")
	public ResponseEntity<Client> add(@RequestBody  Client client) {
		
		try {
			Client c = clientService.add(client.getNomComplet(),client.getTelephone(),client.getEmail(),client.getAdresse());
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
	public ResponseEntity<Client> edit(@RequestBody  Client client, @PathVariable("id") Integer id ) {
		try {
			Client c = clientService.edit(id, client.getNomComplet(),client.getTelephone(),client.getEmail(),client.getAdresse());
			return ResponseEntity.ok().body(c);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// supprimer un client
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		try {
			clientService.delete(id);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
