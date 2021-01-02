package com.desafiozup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String form(@Valid Conta conta, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique se os campos foram preenchidos!");
			return "redirect:/cadastrarClientes";
		}
		cr.save(conta);
		return "redirect:/cadastrarClientes";
	}
	
	@RequestMapping("/deletar")
	public String deletarConta(long id){
		Conta conta = cr.findById(id);
		cr.delete(conta);
		return "redirect:/contas";
	}
	
	
	
	
	@RequestMapping("/contas")
	public ModelAndView ListaContas() {
		ModelAndView mv = new ModelAndView("contas/index");
		Iterable<Conta> contas = cr.findAll();
		mv.addObject("contas", contas);
		return mv;
	}
	

	
}
	
