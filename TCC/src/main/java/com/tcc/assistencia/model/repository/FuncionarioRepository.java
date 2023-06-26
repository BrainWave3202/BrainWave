package com.tcc.assistencia.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcc.assistencia.model.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	//Funcionario findByFuncionarioName(String funcionarioname);
	
	@Query("SELECT f FROM Funcionario f WHERE f.email = :funcionarioEmail")
	Funcionario findByEmail(@Param("funcionarioEmail") String funcionarioEmail);

	
		
}
