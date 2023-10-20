package com.tcc.assistencia.model.entity;

import java.sql.Date;
import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class Servico {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY	)
	private long id;
	
	@Column(name = "nome_do_equipamento")
	private String nomeDoEquipamento;
	
	@Column(name = "descricao_do_problema")
	private String descricaoDoProblema;
	
	@Column(name = "valor_do_servico")
	private Integer valorDoServico;

	@Column(name = "data_de_emissao")
	private Date dataDeEmissao;
	
	@Column(name = "data_de_finalizacao")
	private Date dataDeFinalizacao;
	
	@Column(name = "FUNCIONARIO_ID")
	private Integer funcionarioId;
	
	@Column(name = "Cliente_ID")
	private Integer clienteId;
	
	@Column(name = "estado_servico")	
	private Integer estadoServico;
	
	@Column(name = "descricao_de_troca")	
	private String descricaoDaTroca;

	@Transient
	private String nomeDoFuncionario;
	
	@Transient
	private String imagemBase64;
	 
	@Column
	private byte[] imagem; // Campo de imagem como array de bytes (dados binários)
	    
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeDoEquipamento() {
		return nomeDoEquipamento;
	}

	public void setNomeDoEquipamento(String nomeDoEquipamento) {
		this.nomeDoEquipamento = nomeDoEquipamento;
	}

	public String getDescricaoDoProblema() {
		return descricaoDoProblema;
	}

	public void setDescricaoDoProblema(String descricaoDoProblema) {
		this.descricaoDoProblema = descricaoDoProblema;
	}

	public Integer getValorDoServico() {
		return valorDoServico;
	}

	public void setValorDoServico(Integer valorDoServico) {
		this.valorDoServico = valorDoServico;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Date getDataDeEmissao() {
		return dataDeEmissao;
	}

	public void setDataDeEmissao(Date dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
	}

	public Date getDataDeFinalizacao() {
		return dataDeFinalizacao;
	}

	public void setDataDeFinalizacao(Date dataDeFinalizacao) {
		this.dataDeFinalizacao = dataDeFinalizacao;
	}


	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}

	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}

	public Integer getEstadoServico() {
		return estadoServico;
	}

	public void setEstadoServico(Integer estadoServico) {
		this.estadoServico = estadoServico;
	}

	public String getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	public String getDescricaoDaTroca() {
		return descricaoDaTroca;
	}

	public void setDescricaoDaTroca(String descricaoDaTroca) {
		this.descricaoDaTroca = descricaoDaTroca;
	}



	
	

	
	

}
