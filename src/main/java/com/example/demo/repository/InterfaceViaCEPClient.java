package com.example.demo.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface InterfaceViaCEPClient {
	
	@GetMapping("{cep}/json")
    String buscaEnderecoPor(@PathVariable("cep") String cep);

}
