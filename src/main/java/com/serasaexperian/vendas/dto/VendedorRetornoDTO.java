package com.serasaexperian.vendas.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorRetornoDTO {
	
	private String nome; 
	private String dataInclusao;
	
	private List<String> estados;
}
