package com.tcc.assistencia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcc.assistencia.model.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("SELECT c FROM Cliente c WHERE c.email = :ClienteEmail")
	Cliente findByEmail(@Param("ClienteEmail") String ClienteEmail);
	
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:ClienteNome%")
	List<Cliente> findByNomeContaining(@Param("ClienteNome") String ClienteNome);
}
	