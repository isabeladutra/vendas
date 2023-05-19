package com.serasaexperian.vendas.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "atuacao")
public class Atuacao {
	@Id
	private String regiao;
	
	@ElementCollection
	private List<String> estados;

}
