package com.algaworks.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.input.CidadeInput;
import com.algaworks.algafood.client.model.input.CozinhaInput;
import com.algaworks.algafood.client.model.input.EnderecoInput;
import com.algaworks.algafood.client.model.input.RestauranteInput;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		try {
			String baseUrl = "http://127.0.0.1:8080";
			RestTemplate restTemplate = new RestTemplate();
			RestauranteClient restauranteClient = 
					new RestauranteClient(restTemplate, baseUrl);
			
			CozinhaInput cozinhaInput = new CozinhaInput();
			cozinhaInput.setId(1L);
			
			CidadeInput cidadeInput = new CidadeInput();
			cidadeInput.setId(1L);
			
			EnderecoInput enderecoInput = new EnderecoInput();
			enderecoInput.setBairro("Vila Industrial");
			enderecoInput.setCep("19063-710");
			enderecoInput.setComplemento("Perto do colégio Criarte");
			enderecoInput.setLogradouro("Rua Antônio Furtado de Miranda");
			enderecoInput.setNumero("195");
			enderecoInput.setCidade(cidadeInput);
			
			RestauranteInput restauranteInput = new RestauranteInput();
			restauranteInput.setNome("Restaurante Fim do Módulo");
			restauranteInput.setTaxaFrete(new BigDecimal(5.4));
			restauranteInput.setCozinha(cozinhaInput);
			restauranteInput.setEndereco(enderecoInput);
			
			RestauranteModel restauranteModel = restauranteClient.adicionar(restauranteInput);
			
			System.out.println(restauranteModel);
		} catch (ClientApiException e) {
			if (e.getProblem() != null) {
				System.out.println(e.getProblem().getUserMessage());
				e.getProblem().getObjects().stream()
					.forEach(object -> System.out.println(" - " + object.getUserMessage()));
			} else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}

	}

}
