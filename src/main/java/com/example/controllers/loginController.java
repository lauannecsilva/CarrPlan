package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/login")
    public String exibirLogin() {
        return "resouces/templates/user/login";
    }

    @GetMapping("/teste")
    public String teste(){
        return "index.html";
    }
    
}
