package com.fypproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fypproject.entities.DOP;


@Repository
public interface dopRepository extends JpaRepository<DOP, Integer> {
	 public DOP findByEmail(String email);
	 public DOP findByCity(String city);
	 
}
