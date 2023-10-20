package com.tcc.assistencia.controller;

import java.io.IOException;
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
import com.tcc.assistencia.model.entity.Servico;
import com.tcc.assistencia.model.entity.ServicoForm;
import com.tcc.assistencia.model.repository.ServicoRepository;
import com.tcc.assistencia.model.service.ClienteService;
import com.tcc.assistencia.model.service.FuncionarioService;
import com.tcc.assistencia.model.service.ServicoService;


@Controller
@RequestMapping("api/v1/")
public class AdminController {

	
	@Autowired
	private ClienteService mClienteService;
	
	@Autowired
	private FuncionarioService mFuncionarioService;
	
	@Autowired
	private ServicoService mServicoService;
	
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
		
		return "redirect:controleFuncionario";
	}
	
	@GetMapping("ControleServico")
	public String controleServico(ServicoForm servicoForm, Model model) {
		
		List<Servico> servicos = mServicoService.listarAllServico();
		
		model.addAttribute("servicos", servicos);
		
		
		
		List<Funcionario> funcionario =  mFuncionarioService.listarFuncionario(); 
		model.addAttribute("funcionarios", funcionario);
		
		List<Cliente> clientes = mClienteService.listarAllCliente();
		
		model.addAttribute("clientes", clientes );
		
		
		List<Funcionario> funcionarios =  new ArrayList<>();
		
		for(int i =0; i < servicos.size();i++) {
		
		funcionarios.add(mFuncionarioService.buscaFuncionarioPorId( servicos.get(i).getFuncionarioId()));
		
		servicos.get(i).setNomeDoFuncionario(funcionarios.get(i).getNome()); 
		
		}
		
		
		return "controleServico";
	}
	
	@GetMapping("CadastroServico")
	public String cadastroServico(ServicoForm servicoForm,  Model model) {
		
		List<Funcionario> funcionario =  mFuncionarioService.listarFuncionario(); 
		model.addAttribute("funcionarios", funcionario);
		
		List<Cliente> clientes = mClienteService.listarAllCliente();
		for(int i =0; i < clientes.size();i++) {
		System.out.println(clientes.get(i).getNome());
		}
		model.addAttribute("clientes", clientes );
		
		return "cadastroServico";
	}
	
	@PostMapping("CadastroServico")
	public String cadastrarServico(ServicoForm servicoForm) {
		
	    System.out.println("AAAAAA");
	    
	     	Servico servico = new Servico();
	     	
	        servico.setNomeDoEquipamento(servicoForm.getNomeDoEquipamento());
	        servico.setDescricaoDoProblema(servicoForm.getDescricaoDoProblema());
	        servico.setValorDoServico(servicoForm.getValorDoServico());
	        servico.setFuncionarioId(servicoForm.getFuncionarioId());
	        servico.setClienteId(servicoForm.getClienteId());
	        servico.setDataDeEmissao(servicoForm.getDataDeEmissao());
	        servico.setEstadoServico(servicoForm.getEstadoServico());

	        
	        if (!servicoForm.getImagem().isEmpty()) {
	            try {
	            	
	                byte[] imagemBytes = servicoForm.getImagem().getBytes();
	                servico.setImagem(imagemBytes);
	                // Faça o que for necessário com a imagem (por exemplo, salve-a no banco de dados).
	            } catch (IOException e) {
	                // Trate exceções, se necessário.
	            }
	        }
	    

		
		
		mServicoService.salvarServico(servico);
		
		
		return "redirect:CadastroServico";
	}
	
	@PostMapping("controleServico/{id}")
	public String excluirRegistrosServico(@PathVariable Long id) {
		
		mServicoService.excluirServico(id);
		
		
		return "redirect:/api/v1/ControleServico";
	}
	
	@PostMapping("ControleServico")
	public String atualizaServicos(ServicoForm servicoForm) {
		Servico servico = new Servico();
		servico.setId(servicoForm.getId());
        servico.setNomeDoEquipamento(servicoForm.getNomeDoEquipamento());
        servico.setDescricaoDoProblema(servicoForm.getDescricaoDoProblema());
        servico.setValorDoServico(servicoForm.getValorDoServico());
        servico.setFuncionarioId(servicoForm.getFuncionarioId());
        servico.setClienteId(servicoForm.getClienteId());
        servico.setDataDeEmissao(servicoForm.getDataDeEmissao());
        servico.setEstadoServico(servicoForm.getEstadoServico());
        servico.setDataDeFinalizacao(servicoForm.getDataDeFinalizacao());
        servico.setDescricaoDaTroca(servicoForm.getDescricaoDaTroca());

        System.out.println("aa");
        if (!servicoForm.getImagem().isEmpty()) {
            try {
            	System.out.println("aa");
                byte[] imagemBytes = servicoForm.getImagem().getBytes();
                servico.setImagem(imagemBytes);
                // Faça o que for necessário com a imagem (por exemplo, salve-a no banco de dados).
            } catch (IOException e) {
                // Trate exceções, se necessário.
            }
        }
		
		
		mServicoService.atualizarServico(servico);
		
		
		return "redirect:/api/v1/ControleServico";
	}
	
	
	
	
}
