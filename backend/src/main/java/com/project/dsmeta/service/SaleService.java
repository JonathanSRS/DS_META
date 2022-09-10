package com.project.dsmeta.service;



import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.dsmeta.entities.Sale;
import com.project.dsmeta.repositories.SalesRepository;

@Service
public class SaleService {
	@Autowired
	private SalesRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		//Caso nenhuma Data seja passada por Padrão pega periodo de um ano data atual
		LocalDate min = minDate.equals("")? today.minusDays(365): LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("")? today :LocalDate.parse(maxDate);
		return repository.findSales(min, max, pageable);
	}
}
