package com.bediss.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Hotel;


@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer>{

	Iterable<Hotel> findByNomContainsOrVilleContains(String search, String search2);

}
