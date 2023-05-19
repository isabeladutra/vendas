package com.serasaexperian.vendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.serasaexperian.vendas.dto.VendedorDTO;
import com.serasaexperian.vendas.dto.VendedorRetornoDTO;
import com.serasaexperian.vendas.dto.VendedorRetornoListaDTO;
import com.serasaexperian.vendas.exception.ListaDeVendedorVaziaException;
import com.serasaexperian.vendas.exception.VendedorNaoEncontradoException;
import com.serasaexperian.vendas.model.Atuacao;
import com.serasaexperian.vendas.services.AtuacaoService;
import com.serasaexperian.vendas.services.VendedorService;

public class VendasControllerTests {
	VendedorService vendedorService = Mockito.mock(VendedorService.class);
	AtuacaoService atuacaoService = Mockito.mock(AtuacaoService.class);

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
	public void testaAdicionarVendedor() {
		
		VendasController app = new VendasController();
		app.setAtuacaoService(atuacaoService);
		app.setVendedorService(vendedorService);
		VendedorDTO dto = new VendedorDTO();
		dto.setCidade("Curitiba");
		dto.setEstado("PR");
		dto.setIdade(22);
		dto.setRegiao("sul");
		dto.setNome("Fulano");
		dto.setTelefone("99 99999-9999");
		app.adicionarVendedor(dto);
		verify(vendedorService, times(1)).salvarVendedor(any());
	}
	
	@Test
	public void testaAdicionarAtuacao() {
		VendasController app = new VendasController();
		app.setAtuacaoService(atuacaoService);
		app.setVendedorService(vendedorService);
		Atuacao atuacao = new Atuacao();
		app.adicionarAtuacao(atuacao);		
		verify(atuacaoService, times(1)).salvarAtuacao(any());
		
	}
	
	@Test
	public void testaConsultarVendedorPorId() throws VendedorNaoEncontradoException {
		VendasController app = new VendasController();
		app.setAtuacaoService(atuacaoService);
		app.setVendedorService(vendedorService);
		VendedorRetornoDTO dto = new VendedorRetornoDTO();
		when(vendedorService.buscarVendedorPorId(any())).thenReturn(dto);
		ResponseEntity<VendedorRetornoDTO> resp= app.consultarVendedorPorId(1);
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		
	}
	
	@Test
	public void testaConsultarListaDeVendedores() throws ListaDeVendedorVaziaException {
		VendasController app = new VendasController();
		app.setAtuacaoService(atuacaoService);
		app.setVendedorService(vendedorService);
		List<VendedorRetornoListaDTO> lista = new ArrayList<VendedorRetornoListaDTO>();
		when(vendedorService.buscarListaDeVendedores()).thenReturn(lista);
		ResponseEntity<List<VendedorRetornoListaDTO>>  resp = app.consultarListaDeVendedores();
		assertEquals(HttpStatus.OK, resp.getStatusCode());
	}

}
