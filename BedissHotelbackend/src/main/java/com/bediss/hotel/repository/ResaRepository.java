package com.bediss.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Resa;


@Repository
public interface ResaRepository extends JpaRepository<Resa, Integer> {

}
