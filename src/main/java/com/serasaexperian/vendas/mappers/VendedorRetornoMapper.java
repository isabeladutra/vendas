package com.serasaexperian.vendas.mappers;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.serasaexperian.vendas.dto.VendedorRetornoDTO;
import com.serasaexperian.vendas.model.Vendedor;

import lombok.Data;

@Data
public class VendedorRetornoMapper {
	
	public static VendedorRetornoDTO mapper(Vendedor vendedor, List<String> estados) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = vendedor.getDataDeInclusao().format(formatter);
		return new VendedorRetornoDTO(vendedor.getNome(), dataFormatada, estados);
		
	}

}
