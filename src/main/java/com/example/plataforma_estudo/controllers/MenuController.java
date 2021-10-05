package com.example.plataforma_estudo.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MenuController {

	@GetMapping("/login")
    public String exibirLogin() {
		return "/user/login";
	}

	@GetMapping("/cadastro")
	public String exibirCadastro() {
		return "cadastro";
	}
	


   

    
    
}
