package com.bediss.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bediss.hotel.entities.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
