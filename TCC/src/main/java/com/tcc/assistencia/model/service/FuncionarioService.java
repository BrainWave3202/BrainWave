package com.tcc.assistencia.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.repository.FuncionarioRepository;






@Service
public class FuncionarioService {
	  
	
	
	@Autowired
	private FuncionarioRepository mFuncionarioRepository;
	
	
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		
		return mFuncionarioRepository.save(funcionario);
		
	}
	
	public List<Funcionario> listarFuncionario(){
		
		return mFuncionarioRepository.findAll();
	
	}
	
	public Funcionario buscaFuncionarioPorId(long id) {
		
		return mFuncionarioRepository.findById(id).orElse(null);
	
	}
	
	public Funcionario buscaFuncionarioPorEmail(String email) {
		Funcionario funcionario = mFuncionarioRepository.findByEmail(email);
		
		return funcionario;
		
		
	}
	public Boolean validacaoLogin(String email, String senha ) {
	   
		try {
			
		Funcionario funcionarioLogin = buscaFuncionarioPorEmail(email);
			
			
			if(funcionarioLogin.getSenha().equals(senha)) {
				return  true;
				}
			
			return false;
				
		}catch (EmptyResultDataAccessException  e) {
			
			return false;
			
		}
		
		
		
	}
	
	
	
	
	public void excluirFuncionario(Long id) {
		
		mFuncionarioRepository.deleteById(id);
		
	}
	
	
}
