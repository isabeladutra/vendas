package com.serasaexperian.vendas.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasaexperian.vendas.model.Atuacao;

public interface AtuacaoRepository extends JpaRepository<Atuacao, String>{
     Atuacao findByRegiao(String regiao);
}
