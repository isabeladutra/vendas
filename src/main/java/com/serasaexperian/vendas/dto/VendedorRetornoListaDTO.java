package com.serasaexperian.vendas.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendedorRetornoListaDTO {
	
	private String nome;
	private String telefone;
	private Integer idade;
	private String cidade;
	private String estado;
	
	private List<String> estados;

}
