package com.tcc.assistencia.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.assistencia.model.entity.Cliente;
import com.tcc.assistencia.model.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	
	@Autowired
	public ClienteRepository mClienteRepository;

	public Cliente salvarCliente(Cliente cliente) {
		
		return mClienteRepository.save(cliente);
		
	}
	
	public List<Cliente> listarAllCliente(){
		
		return mClienteRepository.findAll();
	}
	
	public Cliente buscaClientePorId(long id) {
			
		return mClienteRepository.findById(id).orElse(null);
		
	}
		
	public Cliente buscaClientePorEmail(String email) {
			
		Cliente cliente = mClienteRepository.findByEmail(email);
			
		return cliente;
			
			
	}
	public List<Cliente> buscaClientePorNomeContem(String nome) {
		
		List<Cliente> cliente = mClienteRepository.findByNomeContaining(nome);
			
		return cliente;
				
	}
	
	public List<String> pegaNomesDosClientes(List<Cliente> clientes){
		
		List<String> names = new ArrayList<>();
		for(int i = 0; i < clientes.size();i++ ){
			
			Cliente cliente = clientes.get(i);
			names.add(cliente.getNome());  
			
		}
		return names;
	}
	
	public List<String> pegaCpfDosClientes(List<Cliente> clientes){
		
		List<String> cpfS =  new ArrayList<>();
		for(int i = 0; i < clientes.size();i++ ){
			
			Cliente cliente = clientes.get(i);
			cpfS.add(cliente.getCpf());  
			
		}
		return cpfS;
	}
	public List<String> pegaEmailDosClientes(List<Cliente> clientes){
			
			List<String> emails = new ArrayList<>();
			for(int i = 0; i < clientes.size();i++ ){
				
				Cliente cliente = clientes.get(i);
				emails.add(cliente.getEmail());  
				
			}
			return emails;
		}
	
		
	public void excluirFuncionario(Long id) {
			
		mClienteRepository.deleteById(id);
			
	}

    public Cliente atualizarCliente(Cliente clienteAtualizado) {
        // Encontre o cliente existente por email
        Cliente clienteExistente = mClienteRepository.findById(clienteAtualizado.getId()).orElse(null);

        if (clienteExistente != null) {
            // Atualize as propriedades do cliente existente com as novas informações
        	System.out.println(clienteAtualizado.getDataDeNasc());
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setSenha(clienteAtualizado.getSenha());
            clienteExistente.setEmail(clienteAtualizado.getEmail());
            clienteExistente.setDataDeNasc(clienteAtualizado.getDataDeNasc());
            clienteExistente.setCpf(clienteAtualizado.getCpf());
            clienteExistente.setLogradouro(clienteAtualizado.getLogradouro());
            clienteExistente.setCep(clienteAtualizado.getCep());
            clienteExistente.setCidade(clienteAtualizado.getCidade());
            clienteExistente.setBairro(clienteAtualizado.getBairro());
            clienteExistente.setuF(clienteAtualizado.getuF());
            clienteExistente.setComplemento(clienteAtualizado.getComplemento());
            
            
            // Salve o cliente atualizado
            return mClienteRepository.save(clienteExistente);
        } else {
            // Lide com o caso em que o cliente não foi encontrado (pode ser um erro ou uma nova inserção)
            // Neste exemplo, lançamos uma exceção, mas você pode ajustar conforme necessário.
            throw new EntityNotFoundException("Cliente não encontrado");
        }
    }
	
}
