package com.bediss.hotel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Resa;


@Repository
public interface ResaRepository extends CrudRepository<Resa, Integer> {

	Iterable<Resa> findByClientContains(String search);
	
	Optional<Resa> findByClient(String nomClient);

}
