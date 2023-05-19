package com.serasaexperian.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO {
	
	private String nome;
	private String telefone;
	private Integer idade;
	private String cidade;
	private String estado;
	private String regiao;

}
