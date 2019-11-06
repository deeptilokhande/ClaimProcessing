package com.deepti.claimprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepti.claimprocessing.model.Claims;

@Repository
public interface ClaimsRepository extends JpaRepository<Claims, Integer> {

}
