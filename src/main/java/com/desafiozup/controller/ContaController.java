package com.desafiozup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContaController {
	
	@RequestMapping("/cadastroCliente")
	public String form() {
		return "contas/formularioConta";
	}

}
