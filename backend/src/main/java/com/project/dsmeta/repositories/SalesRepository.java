package com.project.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dsmeta.entities.Sale;

public interface SalesRepository extends JpaRepository<Sale, Long>{

}