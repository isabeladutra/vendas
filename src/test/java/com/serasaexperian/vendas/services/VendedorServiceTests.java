package com.serasaexperian.vendas.services;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.serasaexperian.vendas.dto.VendedorRetornoListaDTO;
import com.serasaexperian.vendas.exception.ListaDeVendedorVaziaException;
import com.serasaexperian.vendas.exception.VendedorNaoEncontradoException;
import com.serasaexperian.vendas.model.Atuacao;
import com.serasaexperian.vendas.model.Vendedor;

public class VendedorServiceTests {
	
	private VendedorRepository vendedorRepository= Mockito.mock(VendedorRepository.class);
	
	private AtuacaoRepository atuacaoRepository= Mockito.mock(AtuacaoRepository.class);
	
	private AutoCloseable closeable;
	
	@BeforeEach
	public void initMocks() {
		 closeable = MockitoAnnotations.openMocks(this);
	}
	@AfterEach 
	public void releaseMocks() throws Exception {
        closeable.close();
    }
	
	@Test
	public void testaBuscarVendedorPorId() throws VendedorNaoEncontradoException {
		VendedorService vendedorService = new VendedorService();
		vendedorService.setAtuacaoRepository(atuacaoRepository);
		vendedorService.setVendedorRepository(vendedorRepository);
		Vendedor vend = criaVendedor();
		Atuacao atuacao= new Atuacao();
		List<String> estados = new ArrayList<String>();
		estados.add("PR");
		atuacao.setEstados(estados);
		when(atuacaoRepository.findByRegiao(any())).thenReturn(atuacao);
		when(vendedorRepository.findVendedorById(any())).thenReturn(vend);
		vendedorService.buscarVendedorPorId(1);
		verify(atuacaoRepository, times(1)).findByRegiao(any());
	}
	
	@Test
	public void testaAssociaRegiaoAtuacaoComRegiaoVendedor() {
		VendedorService vendedorService = new VendedorService();
		vendedorService.setAtuacaoRepository(atuacaoRepository);
		vendedorService.setVendedorRepository(vendedorRepository);
		Atuacao atuacao= criaAtuacao();
		when(atuacaoRepository.findByRegiao(any())).thenReturn(atuacao);
		List<String> retorno = vendedorService.associaRegiaoAtuacaoComRegiaoVendedor("sul");
	      assertInstanceOf(List.class, retorno);
	}
	
	@Test
	public void testaBuscarListaDeVendedores() throws ListaDeVendedorVaziaException {
		VendedorService vendedorService = new VendedorService();
		vendedorService.setAtuacaoRepository(atuacaoRepository);
		vendedorService.setVendedorRepository(vendedorRepository);
		List<Vendedor> listaVend = new ArrayList<Vendedor>();
		Vendedor vend = criaVendedor();
		listaVend.add(vend);
		Atuacao atuacao= criaAtuacao();
		when(vendedorRepository.findAll()).thenReturn(listaVend);
		when(atuacaoRepository.findByRegiao(any())).thenReturn(atuacao);
		List<VendedorRetornoListaDTO>  retorno = vendedorService.buscarListaDeVendedores();
		assertInstanceOf(List.class, retorno);
		
	}
	
	public Vendedor criaVendedor() {
		Vendedor vend= new Vendedor();
		vend.setCidade("Curitiba");
		vend.setEstado("PR");
		vend.setIdade(22);
		vend.setRegiao("sul");
		vend.setNome("Fulano");
		vend.setTelefone("99 99999-9999");
		vend.setDataDeInclusao(LocalDate.now());
		return vend;
		
	}
	
	public Atuacao criaAtuacao() {
		Atuacao atuacao= new Atuacao();
		List<String> estados = new ArrayList<String>();
		estados.add("PR");
		atuacao.setEstados(estados);
		return atuacao;
		
	}
	
	

}
