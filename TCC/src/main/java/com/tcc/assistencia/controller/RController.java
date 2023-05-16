package com.tcc.assistencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcc.assistencia.entity.Funcionario;
import com.tcc.assistencia.repository.FuncionarioRepository;

@Controller
@RequestMapping("api/v1/")
public class RController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	@RequestMapping(value="CadastrarFuncionario", method=RequestMethod.GET)
	public String form(){
		
		return "FormFuncionario";
	}
	
	@RequestMapping(value="CadastrarFuncionario", method=RequestMethod.POST)
	public String form(Funcionario funcionario){
		
		fr.save(funcionario);
		
		return "redirect:CadastrarFuncionario";
	}
}
