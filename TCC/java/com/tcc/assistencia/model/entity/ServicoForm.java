package com.tcc.assistencia.model.entity;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

public class ServicoForm {

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

		@Column(name = "descricao_de_troca")	
		private String descricaoDaTroca;
		
		@Column(name = "estado_servico")	
		private Integer estadoServico;
		
		@Transient
		private String nomeDoFuncionario;
	    
	    private MultipartFile imagem;
	    
	    
	    
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
		public MultipartFile getImagem() {
			return imagem;
		}
		public void setImagem(MultipartFile imagem) {
			this.imagem = imagem;
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
		public String getDescricaoDaTroca() {
			return descricaoDaTroca;
		}
		public void setDescricaoDaTroca(String descricaoDaTroca) {
			this.descricaoDaTroca = descricaoDaTroca;
		}
	
		
		
	

}
