package com.serasaexperian.vendas.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.serasaexperian.vendas.model.Atuacao;

public class AtuacaoServiceTests {
	
	AtuacaoRepository atuacaoRepository = Mockito.mock(AtuacaoRepository.class);

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
	public void testaSalvarAtuacao() {
		Atuacao atuacao= new Atuacao();
		AtuacaoService service = new AtuacaoService();
		service.setAtuacaoRepository(atuacaoRepository);
		service.salvarAtuacao(atuacao);
		verify(atuacaoRepository, times(1)).save(any());
		
	}
}
