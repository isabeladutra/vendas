package com.serasaexperian.vendas.mappers;

import java.util.List;

import com.serasaexperian.vendas.dto.VendedorRetornoListaDTO;
import com.serasaexperian.vendas.model.Vendedor;

import lombok.Data;

@Data
public class VendedorRetornoListaMapper {
	public static VendedorRetornoListaDTO mapper(Vendedor vendedor, List<String> estados) {
		return new VendedorRetornoListaDTO(vendedor.getNome(), vendedor.getTelefone(), vendedor.getIdade(), vendedor.getCidade(), vendedor.getEstado(), estados);
		
	}

}
