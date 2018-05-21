package com.example.demo.endpoint;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Endereco;

@Component
public class ViaCEPClient implements CommandLineRunner {
 
    private static void buscaEnderecoPor(String cep){
        RestTemplate template = new RestTemplate();
        Endereco endereco = template.getForObject("https://viacep.com.br/ws/{cep}/json",Endereco.class, cep);
        
        System.out.println(endereco);
    }

	@Override
	public void run(String... args) throws Exception {
		buscaEnderecoPor("58051550");
		
	}
}