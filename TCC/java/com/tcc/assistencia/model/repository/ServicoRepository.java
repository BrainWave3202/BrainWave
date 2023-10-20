package com.tcc.assistencia.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.tcc.assistencia.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	


	
}
