package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Endereco;
import com.example.demo.repository.InterfaceViaCEPClient;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
@Produces(MediaType.APPLICATION_JSON)
public class Teste {
	
	@Autowired
	private InterfaceViaCEPClient cliente;
	
	
	@GetMapping("/cossulta/{cep}")
    public Endereco list(@PathVariable("cep") String cep) {
		
		String json = cliente.buscaEnderecoPor(cep);

		Gson gson = new Gson();
		
		Endereco e = gson.fromJson(json, Endereco.class);
		
	    return e;
		
    }
	
	
}
