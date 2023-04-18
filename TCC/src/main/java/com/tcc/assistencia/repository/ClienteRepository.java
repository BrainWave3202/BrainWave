package com.tcc.assistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tcc.assistencia.entity.Funcionario;

public interface ClienteRepository extends JpaRepository<Funcionario, Long> {

}
