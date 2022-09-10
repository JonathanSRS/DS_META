package com.project.dsmeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dsmeta.entities.Sale;
import com.project.dsmeta.repositories.SalesRepository;

@Service
public class SaleService {
	@Autowired
	private SalesRepository repository;
	
	public List <Sale> findSales(){
		return repository.findAll();
	}
}
