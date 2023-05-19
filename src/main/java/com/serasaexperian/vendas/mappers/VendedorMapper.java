package com.serasaexperian.vendas.mappers;

import java.time.LocalDate;

import com.serasaexperian.vendas.dto.VendedorDTO;
import com.serasaexperian.vendas.model.Vendedor;

import lombok.Data;

@Data
public class VendedorMapper {

	public static Vendedor mapper(VendedorDTO vendedorDto) {
		Vendedor vendedor = new Vendedor();
		vendedor.setCidade(vendedorDto.getCidade());
		vendedor.setEstado(vendedorDto.getEstado());
		vendedor.setIdade(vendedorDto.getIdade());
		vendedor.setNome(vendedorDto.getNome());
		vendedor.setDataDeInclusao(LocalDate.now());
		vendedor.setRegiao(vendedorDto.getRegiao());
		vendedor.setTelefone(vendedorDto.getTelefone());
		return vendedor;
	}
}
