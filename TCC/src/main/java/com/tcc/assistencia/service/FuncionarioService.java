package com.tcc.assistencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcc.assistencia.entity.Funcionario;
import com.tcc.assistencia.repository.FuncionarioRepository;

public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository mFuncionarioRepository;
	
	public Funcionario cadastrarPessoa(Funcionario funcionario) {
		
		return mFuncionarioRepository.save(funcionario);
		
	}
	
	public List<Funcionario> listarFuncionario(){
		
		return mFuncionarioRepository.findAll();
	
	}
	
	
	
}
