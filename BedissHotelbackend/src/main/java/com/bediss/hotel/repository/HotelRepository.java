package com.bediss.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Hotel;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
