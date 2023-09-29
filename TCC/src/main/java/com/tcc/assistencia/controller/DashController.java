package com.tcc.assistencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.service.FuncionarioService;

@Controller
@RequestMapping("api/v1/")
public class DashController {
	
	@Autowired
	private FuncionarioService mFuncionarioService;
	
	@GetMapping("Servicos_previa")
	public String servicosPrevia(){
		
		
		return "servicos_previa";
	}
	
	
	@GetMapping("Servicos_analise")
	public String servicosAndamento(Model model){
		 List<Funcionario> funcionariosImpar = mFuncionarioService.ListarFuncionarioImpar();
		 List<Funcionario> funcionariosPar = mFuncionarioService.ListarFuncionarioPar();
	     model.addAttribute("funcionariosImpar", funcionariosImpar);
	     model.addAttribute("funcionariosPar", funcionariosPar);
		return "servicos_analise";
	}
	
	@GetMapping("teste")
	public String teste(Model model) {
		 List<Funcionario> funcionariosImpar = mFuncionarioService.ListarFuncionarioImpar();
		 List<Funcionario> funcionariosPar = mFuncionarioService.ListarFuncionarioPar();
	     model.addAttribute("funcionariosImpar", funcionariosImpar);
	     model.addAttribute("funcionariosPar", funcionariosPar);
	     return "teste";
	}
	
	@GetMapping("ServicoInf")
	public String servicoInf(Model model) {
		
		
		
		return "especificacoes_analise";
	}
	
	
	
}
