package com.serasaexperian.vendas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.serasaexperian.vendas.dto.VendedorDTO;
import com.serasaexperian.vendas.dto.VendedorRetornoDTO;
import com.serasaexperian.vendas.dto.VendedorRetornoListaDTO;
import com.serasaexperian.vendas.exception.ListaDeVendedorVaziaException;
import com.serasaexperian.vendas.exception.VendedorNaoEncontradoException;
import com.serasaexperian.vendas.mappers.VendedorMapper;
import com.serasaexperian.vendas.model.Atuacao;
import com.serasaexperian.vendas.model.Vendedor;
import com.serasaexperian.vendas.services.AtuacaoService;
import com.serasaexperian.vendas.services.VendedorService;

@RestController
public class VendasController {
	
	@Autowired
	VendedorService vendedorService;
	
	public void setVendedorService(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}

	public void setAtuacaoService(AtuacaoService atuacaoService) {
		this.atuacaoService = atuacaoService;
	}

	@Autowired
	AtuacaoService atuacaoService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/vendedor")
	public void adicionarVendedor(@RequestBody VendedorDTO vendedor) {
	    //
		Vendedor vend = VendedorMapper.mapper(vendedor);
		vendedorService.salvarVendedor(vend);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/atuacao")
	public void adicionarAtuacao(@RequestBody Atuacao atuacao) {
	    //
		atuacaoService.salvarAtuacao(atuacao);
	}
	
	@GetMapping(value ="/vendedor/{id}")
	public ResponseEntity<VendedorRetornoDTO> consultarVendedorPorId(@PathVariable Integer id) {
		
		VendedorRetornoDTO retorno = new VendedorRetornoDTO();
		HttpStatus returnStatusCode = HttpStatus.OK;
		
		try {
		   retorno = vendedorService.buscarVendedorPorId(id);
		} catch (VendedorNaoEncontradoException e) {
			returnStatusCode = HttpStatus.NO_CONTENT;
			e.printStackTrace();
		}
		return new ResponseEntity<VendedorRetornoDTO>(retorno ,returnStatusCode);
	}
	
	@GetMapping(value ="/vendedor")
	public ResponseEntity<List<VendedorRetornoListaDTO>> consultarListaDeVendedores() {
		
		List<VendedorRetornoListaDTO> lista = new ArrayList<VendedorRetornoListaDTO>();
		HttpStatus returnStatusCode = HttpStatus.OK;
		try {
			lista = vendedorService.buscarListaDeVendedores();
		} catch (ListaDeVendedorVaziaException e) {
			returnStatusCode = HttpStatus.NO_CONTENT;
			e.printStackTrace();
		}
		return new ResponseEntity<List<VendedorRetornoListaDTO>>(lista, returnStatusCode);
		
	}
	
	


}
