package com.project.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dsmeta.entities.Sale;

public interface SalesRepository extends JpaRepository<Sale, Long>{
	//Método customizado
	@Query("SELECT obj FROM Sale obj WHERE obj.data BETWEEN :min AND :max ORDER BY obj.total DESC")
	//Páginando Resultados 
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pegeable);
}
