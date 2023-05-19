package com.serasaexperian.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasaexperian.vendas.model.Atuacao;

@Service
public class AtuacaoService {
	
	@Autowired
	AtuacaoRepository atuacaoRepository;
	
	public void setAtuacaoRepository(AtuacaoRepository atuacaoRepository) {
		this.atuacaoRepository = atuacaoRepository;
	}

	public void salvarAtuacao(Atuacao atuacao) {
		atuacaoRepository.save(atuacao);
		
	}

}
