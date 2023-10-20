package com.tcc.assistencia.model.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.repository.FuncionarioRepository;

@Service
public class AuthService {
	 	private final FuncionarioRepository funcionarioRepository;
	 	
	 	@Autowired
	    public AuthService(FuncionarioRepository funcionarioRepository) {
	        this.funcionarioRepository = funcionarioRepository;
	    }

	    public Optional<Funcionario> authenticate(String email, String password) {
	        Funcionario funcionario = funcionarioRepository.findByEmail(email);

	        if (funcionario != null && funcionario.getSenha().equals(password)) {
	            return Optional.of(funcionario);
	        } else {
	            return Optional.empty();
	        }
	    }
}
