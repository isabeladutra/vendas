package com.serasaexperian.vendas.services;



import org.springframework.data.jpa.repository.JpaRepository;

import com.serasaexperian.vendas.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	Vendedor findVendedorById(Integer id);

}
