package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteModel {

	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private Boolean aberto;
	private Boolean ativo;
	
	private CozinhaModel cozinha;
	private EnderecoModel endereco;
	
}
