package com.serasaexperian.vendas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasaexperian.vendas.dto.VendedorRetornoDTO;
import com.serasaexperian.vendas.dto.VendedorRetornoListaDTO;
import com.serasaexperian.vendas.exception.ListaDeVendedorVaziaException;
import com.serasaexperian.vendas.exception.VendedorNaoEncontradoException;
import com.serasaexperian.vendas.mappers.VendedorRetornoListaMapper;
import com.serasaexperian.vendas.mappers.VendedorRetornoMapper;
import com.serasaexperian.vendas.model.Atuacao;
import com.serasaexperian.vendas.model.Vendedor;

@Service
public class VendedorService {

	@Autowired
	VendedorRepository vendedorRepository;

	public void setVendedorRepository(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}

	@Autowired
	AtuacaoRepository atuacaoRepository;

	public void setAtuacaoRepository(AtuacaoRepository atuacaoRepository) {
		this.atuacaoRepository = atuacaoRepository;
	}

	public void salvarVendedor(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}

	public VendedorRetornoDTO buscarVendedorPorId(Integer id) throws VendedorNaoEncontradoException {
		Vendedor vend = vendedorRepository.findVendedorById(id);

		if (vend == null) {
			throw new VendedorNaoEncontradoException("Vendedor Não Existe");
		}
		List<String> estados = associaRegiaoAtuacaoComRegiaoVendedor(vend.getRegiao());
		return VendedorRetornoMapper.mapper(vend, estados);

	}

	public List<VendedorRetornoListaDTO> buscarListaDeVendedores() throws ListaDeVendedorVaziaException {
		List<VendedorRetornoListaDTO> listaDeRetorno = new ArrayList<VendedorRetornoListaDTO>();
		List<Vendedor> listaVend = vendedorRepository.findAll();
		if (listaVend.isEmpty()) {
			throw new ListaDeVendedorVaziaException("Nenhum Vendedor Encontrado");
		}
		for (Vendedor item : listaVend) {
			List<String> estados = associaRegiaoAtuacaoComRegiaoVendedor(item.getRegiao());
			VendedorRetornoListaDTO vended = VendedorRetornoListaMapper.mapper(item, estados);
			listaDeRetorno.add(vended);
		}
		return listaDeRetorno;

	}

	public List<String> associaRegiaoAtuacaoComRegiaoVendedor(String regiao) {
		// associa a regiao da atuacao com a regiao do vendedor
		Atuacao atuacao = atuacaoRepository.findByRegiao(regiao);
		return atuacao.getEstados();

	}

}
