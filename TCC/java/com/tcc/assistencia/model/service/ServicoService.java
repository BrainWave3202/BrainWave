package com.tcc.assistencia.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tcc.assistencia.model.entity.Cliente;
import com.tcc.assistencia.model.entity.Servico;

import com.tcc.assistencia.model.repository.ServicoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	public ServicoRepository mServicoRepository;


	public Servico salvarServico(Servico servico) {
		
		return mServicoRepository.save(servico);
			
	}
	
	public List<Servico> listarAllServico(){
		
		return mServicoRepository.findAll();
	}
	
	public Servico listarPorId(Long id) {
		
		return mServicoRepository.findById(id).orElse(null);
	}
	
	
	public void excluirServico(Long id) {
			
		mServicoRepository.deleteById(id);
		
	}
	
	  public Servico atualizarServico(Servico servicoAtualizado) {
		  
	        // Encontre o cliente existente por email
	        Servico servicoExistente = mServicoRepository.findById(servicoAtualizado.getId()).orElse(null);

	        if (servicoExistente != null) {
	            // Atualize as propriedades do cliente existente com as novas informações
	        	if(servicoAtualizado.getNomeDoEquipamento() != null && !servicoAtualizado.getNomeDoEquipamento().isEmpty()) {
	        	servicoExistente.setNomeDoEquipamento(servicoAtualizado.getNomeDoEquipamento());   
	        	}
	        	if(servicoAtualizado.getDescricaoDoProblema() != null && !servicoAtualizado.getDescricaoDoProblema().isEmpty()) {
	        	servicoExistente.setDescricaoDoProblema(servicoAtualizado.getDescricaoDoProblema());
	        	}
	        	if(servicoAtualizado.getDataDeEmissao() != null && !String.valueOf(servicoAtualizado.getDataDeFinalizacao()).isEmpty()) {
	        	servicoExistente.setDataDeEmissao(servicoAtualizado.getDataDeEmissao());
	        	}
	        	if(servicoAtualizado.getDataDeFinalizacao() != null && !String.valueOf(servicoAtualizado.getDataDeFinalizacao()).isEmpty()) {
	        	servicoExistente.setDataDeFinalizacao(servicoAtualizado.getDataDeFinalizacao());
	        	}
	        	if(servicoAtualizado.getImagem() != null  && !String.valueOf(servicoAtualizado.getImagem()).isEmpty()) {
	        	servicoExistente.setImagem(servicoAtualizado.getImagem());
	        	}
	        	if(servicoAtualizado.getValorDoServico() != null &&  !String.valueOf(servicoAtualizado.getValorDoServico()).isEmpty()) {
	        	servicoExistente.setValorDoServico(servicoAtualizado.getValorDoServico());
	        	}
	        	if(servicoAtualizado.getClienteId() != null &&  !String.valueOf(servicoAtualizado.getClienteId()).isEmpty() ) {
	        	servicoExistente.setClienteId(servicoAtualizado.getClienteId());
	        	}
	        	if(servicoAtualizado.getFuncionarioId() != null &&  !String.valueOf(servicoAtualizado.getFuncionarioId()).isEmpty()) {
	        	servicoExistente.setFuncionarioId(servicoAtualizado.getFuncionarioId());
	        	}
	        	if(servicoAtualizado.getEstadoServico() != null && !String.valueOf(servicoAtualizado.getEstadoServico()).isEmpty()) {
	        	servicoExistente.setEstadoServico(servicoAtualizado.getEstadoServico());
	        	}
	        	
	        	if(servicoAtualizado.getDescricaoDaTroca() != null && !servicoAtualizado.getDescricaoDaTroca().isEmpty()) {
	        		servicoExistente.setDescricaoDaTroca(servicoAtualizado.getDescricaoDaTroca());
	        	}
	        
	        	
	            
	            
	            
	            // Salve o cliente atualizado
	            return mServicoRepository.save(servicoExistente);
	        } else {
	            // Lide com o caso em que o cliente não foi encontrado (pode ser um erro ou uma nova inserção)
	            // Neste exemplo, lançamos uma exceção, mas você pode ajustar conforme necessário.
	            throw new EntityNotFoundException("Cliente não encontrado");
	        }
	    }
	  
	  
	  public Servico procurarServiçoPorDataMaisAntigaDeEmissao(int Estado) {
	        List<Servico> services = mServicoRepository.findAll();
	        List<Servico> servicos = new ArrayList<>();
       
        	
	        for(int i = 0; i < services.size() ; i++) {
	        	
	    		
	    		
	    		if(services.get(i).getEstadoServico() == Estado) {
	        		servicos.add(services.get(i));
	    
	        	}
	        }
	        
	       
	        
	        if (!servicos.isEmpty()) {
	            // Ordena a lista de serviços com base na data de emissão
	        	servicos.sort(Comparator.comparing(Servico::getDataDeEmissao));

	            return servicos.get(0); // O primeiro serviço tem a data de emissão mais antiga
	        }

	        return null; // Retorna null se nenhum serviço for encontrado
	    }
	
	  public List<Servico> procurarServiçoEstado(int Estado) {
	        List<Servico> services = mServicoRepository.findAll();
	        List<Servico> servicos = new ArrayList<>();
	        System.out.println(services);
	        System.out.println(servicos);
	        for(int i = 0; i < services.size() ; i++) {
	        	
	    		
	    		
	    		if(services.get(i).getEstadoServico() == Estado) {
	        		servicos.add(services.get(i));
	    
	        	}
	        }
	        
	       
	        
	        if (!servicos.isEmpty()) {
	            // Ordena a lista de serviços com base na data de emissão
	        	servicos.sort(Comparator.comparing(Servico::getDataDeEmissao));

	            return servicos; // O primeiro serviço tem a data de emissão mais antiga
	        }

	        return null; // Retorna null se nenhum serviço for encontrado
	    }
	
	

}
