package com.tcc.assistencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcc.assistencia.entity.Funcionario;
import com.tcc.assistencia.repository.FuncionarioRepository;
import com.tcc.assistencia.service.FuncionarioService;

@Controller
@RequestMapping("api/v1/")
public class RController {
	
	
	private FuncionarioRepository fr;
	
	

	@Autowired
	private FuncionarioService mFuncionarioService;


	
	@GetMapping("CadastrarFuncionario")
	public String form(){
		
		return "FormFuncionario";
		
	}
	
	
	
	@PostMapping("CadastrarFuncionario")
	public  ResponseEntity<Funcionario> cadastrarFuncionario( Funcionario funcionario){
		
		Funcionario funcionarioCadastro = mFuncionarioService.salvarFuncionario(funcionario);
		
		return ResponseEntity.ok(funcionarioCadastro);
		
		
	}
	
	
	
	/*
	
	@PostMapping("CadastrarFuncionario")	
	public String form(Funcionario funcionario){
		
		fr.save(funcionario);
		
		return "redirect:CadastrarFuncionario";
		
	}
	
	*/
}
