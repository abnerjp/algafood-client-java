package com.algaworks.algafood.client;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.RestauranteClient;

public class ListagemRestaurantesMain {

	public static void main(String[] args) {
		String baseUrl = "http://127.0.0.1:8080";
		RestTemplate restTemplate = new RestTemplate();
		
		RestauranteClient restauranteClient = new RestauranteClient(restTemplate, baseUrl);
		
		restauranteClient.listar().stream()
			.forEach(restaurante -> System.out.println(restaurante));
		
	}

}
