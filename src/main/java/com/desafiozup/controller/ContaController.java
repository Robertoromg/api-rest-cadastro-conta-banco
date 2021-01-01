package com.desafiozup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafiozup.models.Conta;
import com.desafiozup.repository.ContaRepository;

@Controller
public class ContaController {
	
	@Autowired
	private ContaRepository cr;
	
	@RequestMapping(value="/cadastrarClientes", method=RequestMethod.GET)
	public String form() {
		return "contas/formularioConta";
	}
	
	@RequestMapping(value="/cadastrarClientes", method=RequestMethod.POST)
	public String form(Conta conta) {
		
		cr.save(conta);
		return "redirect:/cadastrarClientes";
	}
	
	@RequestMapping("/contas")
	public ModelAndView ListaContas() {
		ModelAndView mv = new ModelAndView("contas/index");
		Iterable<Conta> contas = cr.findAll();
		mv.addObject("contas", contas);
		return mv;
	}

}
