package com.tcc.assistencia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		return mFuncionarioRepository.findByEmail(email);
	}
	
	
	
	public void excluirFuncionario(Long id) {
		
		mFuncionarioRepository.deleteById(id);
		
	}
	
	
}
