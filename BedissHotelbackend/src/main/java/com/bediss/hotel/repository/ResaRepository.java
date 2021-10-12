package com.bediss.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Resa;


@Repository
public interface ResaRepository extends CrudRepository<Resa, Integer> {

	Iterable<Resa> findByClientContains(String search);

}
