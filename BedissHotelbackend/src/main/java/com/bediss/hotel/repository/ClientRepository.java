package com.bediss.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
