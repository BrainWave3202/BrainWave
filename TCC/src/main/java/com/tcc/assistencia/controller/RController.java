package com.tcc.assistencia.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.service.FuncionarioService;

@Controller
@RequestMapping("api/v1/")
public class RController {
	
	@Autowired
	private FuncionarioService mFuncionarioService;

	
	@GetMapping("CadastrarFuncionario")
	public String form(){
		
		return "cadastro";
		
	}
	
	@GetMapping("login")
	public String redirecionaParaLogin() {
		
		return "login";
	
	}
	
	@GetMapping("tela_inicial")
	public String telaInicial() {
		return "tela_inicial";
	}
	
	@PostMapping("login")
	public String validaLogin(Funcionario funcionario, Model model) {
		try {
			if(funcionario.getEmail().equals("")) {
				
			model.addAttribute("aviso", "Email invalida");
			return "login";
				
			}
		Funcionario funcionarioLogin = mFuncionarioService.buscaFuncionarioPorEmail(funcionario.getEmail());
			
			if(funcionarioLogin.getSenha().equals(funcionario.getSenha())) {
				return  "redirect:tela_inicial";
			}
			model.addAttribute("aviso", "Senha invalida");
			return "login";
				
		}catch (EmptyResultDataAccessException  e) {
			model.addAttribute("aviso","Email invalido");
			System.out.println(e);
			return "login";
		}
		
	}
	
	
	@PostMapping("CadastrarFuncionario")
	public String cadastrarFuncionario(Funcionario funcionario, Model model){
		if(funcionario.getNome().equals("")) {
			model.addAttribute("aviso", "Insira o nome");
			return "cadastro";
		}else if(funcionario.getEmail().equals("")) {
			model.addAttribute("aviso", "Insira o email");
			return "cadastro";
		}else if(funcionario.getCpf().equals("")) {
			model.addAttribute("aviso", "Insira o cpf");
			return "cadastro";
		}else if(funcionario.getSenha().equals("")) {
			model.addAttribute("aviso", "Insira o senha");
			return "cadastro";
		}
		
		mFuncionarioService.salvarFuncionario(funcionario);	
		model.addAttribute("aviso", "Cadastro bem-sucedido");
		return "cadastro";
	}
	
	
	
	
	
	
	/*
		@PostMapping("CadastrarFuncionario")
	public ResponseEntity<Funcionario> cadastrarFuncionario( Funcionario funcionario){
		
		Funcionario funcionarioCadastro = mFuncionarioService.salvarFuncionario(funcionario);
		
		return ResponseEntity.ok(funcionarioCadastro);
		
		
	}
	*/
	
	/*
	
	@PostMapping("CadastrarFuncionario")	
	public String form(Funcionario funcionario){
		
		fr.save(funcionario);
		
		return "redirect:CadastrarFuncionario";
		
	}
	
	*/
}
