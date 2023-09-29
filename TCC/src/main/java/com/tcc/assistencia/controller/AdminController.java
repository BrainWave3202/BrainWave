package com.tcc.assistencia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcc.assistencia.model.entity.Cliente;
import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.service.ClienteService;
import com.tcc.assistencia.model.service.FuncionarioService;


@Controller
@RequestMapping("api/v1/")
public class AdminController {

	
	@Autowired
	private ClienteService mClienteService;
	@Autowired
	private FuncionarioService mFuncionarioService;
	
	@GetMapping("telaCadastros")
	public String escolhaCadastros() {
		
		
		return "telaCadastros";
	}
	
	
	@GetMapping("Admin")
	public String admin(@RequestParam(required = false) String texto, Model model, Cliente cliente) {
		List<Cliente> clientes = new ArrayList<>();
		List<Cliente> clientesPesquisa = new ArrayList<>();
		if(texto != null ) {
	
		clientesPesquisa = mClienteService.buscaClientePorNomeContem(texto);
		
		 model.addAttribute("clientesPesquisa", clientesPesquisa);
			
		model.addAttribute("texto", texto);
		System.out.println("true");
		}else {
		
		
        clientes = mClienteService.listarAllCliente();
		
        model.addAttribute("clientes", clientes);
		
		System.out.println("else");
		}
		
		for(int i = 0; i < clientes.size(); i++) {
		System.out.println(clientes.get(i).getNome());
		}
		
	    model.addAttribute("cliente", cliente); // Adicione o objeto cliente ao modelo
		
		return "controleCliente";
	}
	
	

	
	@PostMapping("Admin/{id}")
	public String excluirRegistrosCliente(@PathVariable Long id) {
		
		
		mClienteService.excluirFuncionario(id);
		
		
		return "redirect:/api/v1/Admin";
	}
	
	
	@PostMapping("Admin")
	public String atualizarCliente(@ModelAttribute Cliente cliente) {
	
		mClienteService.atualizarCliente(cliente);
	
		
		return "redirect:/api/v1/Admin";
	}
	
	@GetMapping("controleFuncionario")
	public String controleFuncionario(Model model,Funcionario funcionario){
		
		List<Funcionario> funcionarios  = mFuncionarioService.listarFuncionario();
		
		model.addAttribute("funcionarios", funcionarios);
		
		return "controleFuncionario";
	}
	
	@PostMapping("controleFuncionario/{id}")
	public String excluirRegistrosFuncionario(@PathVariable Long id) {
		
		mFuncionarioService.excluirFuncionario(id);
		
		
		return "redirect:/api/v1/controleFuncionario";
	}
	
	@PostMapping("controleFuncionario")
	public String atualizarFuncionarios(@ModelAttribute Funcionario funcionario) {
	
		mFuncionarioService.atualizarFuncionario(funcionario);
	
		
		return "redirect:/api/v1/controleFuncionario";
	}
	
	
	
	@GetMapping("CadastroCliente")
	public String cadastroCliente(Cliente cliente){
		
		
		return "cadastro_cliente";
	}
	
	@PostMapping("CadastroCliente")
	public String cadastrarCliente(Cliente cliente){
		
		mClienteService.salvarCliente(cliente);
		
		
		return "redirect:CadastroCliente";
	}
	
	@GetMapping("CadastroFuncionario")
	public String cadastroFuncionario(Funcionario funcionario){
		
		
		return "cadastroFuncionario";
	}
	
	@PostMapping("CadastroFuncionario")
	public String cadastrarFuncionario(Funcionario funcionario){
		
		mFuncionarioService.salvarFuncionario(funcionario);
		
		
		return "redirect:CadastroFuncionario";
	}
	
	@GetMapping("ControleServico")
	public String cadastrarServico() {
		
		return "controleServico";
	}
	
	
	
	
	
	
}
