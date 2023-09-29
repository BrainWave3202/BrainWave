package com.tcc.assistencia.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Servico {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY	)
	private long id;
	
	@Column()
	private String NomeDeServiço;


}
