package com.tcc.assistencia.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tcc.assistencia.model.entity.Cliente;
import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.repository.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;



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
	
	public List<Funcionario> ListarFuncionarioPar(){
		
		return mFuncionarioRepository.findByIdPar();
		
	}
	
	public List<Funcionario> ListarFuncionarioImpar(){
		
		return mFuncionarioRepository.findByIdImpar();
		
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
	 public Funcionario atualizarFuncionario(Funcionario funcionarioAtualizado) {
	        // Encontre o cliente existente por email
		 Funcionario funcionarioExistente = mFuncionarioRepository.findById(funcionarioAtualizado.getId()).orElse(null);

	        if (funcionarioExistente != null) {
	            // Atualize as propriedades do cliente existente com as novas informações
	        	System.out.println(funcionarioAtualizado.getDataDeNasc());
	        	funcionarioExistente.setNome(funcionarioAtualizado.getNome());
	        	funcionarioExistente.setSenha(funcionarioAtualizado.getSenha());
	        	funcionarioExistente.setEmail(funcionarioAtualizado.getEmail());
	        	funcionarioExistente.setDataDeNasc(funcionarioAtualizado.getDataDeNasc());
	        	funcionarioExistente.setCpf(funcionarioAtualizado.getCpf());
	        	funcionarioExistente.setLogradouro(funcionarioAtualizado.getLogradouro());
	        	funcionarioExistente.setCep(funcionarioAtualizado.getCep());
	        	funcionarioExistente.setCidade(funcionarioAtualizado.getCidade());
	        	funcionarioExistente.setBairro(funcionarioAtualizado.getBairro());
	        	funcionarioExistente.setuF(funcionarioAtualizado.getuF());
	        	funcionarioExistente.setComplemento(funcionarioAtualizado.getComplemento());
	            
	            
	            // Salve o cliente atualizado
	            return mFuncionarioRepository.save(funcionarioExistente);
	        } else {
	            // Lide com o caso em que o cliente não foi encontrado (pode ser um erro ou uma nova inserção)
	            // Neste exemplo, lançamos uma exceção, mas você pode ajustar conforme necessário.
	            throw new EntityNotFoundException("Cliente não encontrado");
	        }
	    }
	
	
	
	
	public void excluirFuncionario(Long id) {
		
		mFuncionarioRepository.deleteById(id);
		
	}
	
	
}
