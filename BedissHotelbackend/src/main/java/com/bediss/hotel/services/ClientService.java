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
	
	
	private void checkClient(String nom, String telephone, String email, String ville) throws Exception {
        // vérification du nom complet qui ne peut pas être infèrieur à 2 caractères
        if (nom.length() < 2){
            throw new Exception("nom complet invalide");
        }

        // telephone supèrieur à 9 et infèrieur à 16 caractères
        if (telephone.length() > 9 && telephone.length() < 15){
            throw new Exception("Le numéro doit contenir 10 chiffres avec espaces ou tirets");
        }

        // l'email doit être supèrieur à 2 caractères
        if (email.length() < 2){
            throw new Exception("Votre email est invalide");
        }

        // la ville doit être supèrieur à 2 caractères
        if (ville.length() < 2){
            throw new Exception("Votre ville est invalide");
        }
    }
	

}
