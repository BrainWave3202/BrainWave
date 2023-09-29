package com.tcc.assistencia.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.repository.FuncionarioRepository;
import com.tcc.assistencia.model.service.FuncionarioService;

@Controller
@RequestMapping("api/v1/")
public class AuthController {
	
	@Autowired
	private FuncionarioService mFuncionarioService;

	//Mapeamento cadastro funcionario
	@GetMapping("CadastrarFuncionario")
	public String form(Funcionario funcionario){
		
		return "cadastro";
		
	}
	
	//Mapeamento login funcionario
	@GetMapping("login")
	public String redirecionaParaLogin() {
		
		return "login";
	
	}
	
	//Mapeamento tela inicial 
	@GetMapping("tela_inicial")
	public String telaInicial() {
		return "tela_inicial";
	}
	
	//Validacao de login 
	@PostMapping("login")
	public String login(Funcionario funcionario, Model model) {
		 String email = funcionario.getEmail().trim();
	     String senha = funcionario.getSenha().trim();
	     
	     if (email.isEmpty() || senha.isEmpty()) {
		        model.addAttribute("aviso", "Preencha todos os campos.");
		        return "login";
		    }
	     
	     try {
	     boolean loginValidado = mFuncionarioService.validacaoLogin(email, senha);
	     if(loginValidado) {
	    	 
	    	 return "redirect:tela_inicial";
	     	}
	     	model.addAttribute("aviso", "Credenciais inválidas. Verifique seu email e senha.");
	 		return "login";
	     }catch (Exception e) {
	    	 model.addAttribute("aviso", "Credenciais inválidas. Verifique seu email e senha.");
	 		return "login";
		}
	  
	    
	}
	
	/*
	public String validaLogin(Funcionario funcionario, Model model) {
		try {
			if(funcionario.getEmail().equals("")) {
				
			model.addAttribute("aviso", "Email invalida");
			return "login";
				
			}
		Funcionario funcionarioLogin = mFuncionarioService.buscaFuncionarioPorEmail(funcionario.getEmail());
			
			if(funcionarioLogin.getSenha().equals(funcionario.getSenha())) {
				return  "redirect:tela_inicial";
			}
			model.addAttribute("aviso", "Senha invalida");
			return "login";
				
		}catch (EmptyResultDataAccessException  e) {
			model.addAttribute("aviso","Email invalido");
			System.out.println(e);
			return "login";
		}
		
	}
	*/
	//Cadastro de funcionario
	@PostMapping("CadastrarFuncionario")
	public String cadastrarFuncionario(@RequestParam("codigoValidacao") String codigoValidacao, @ModelAttribute Funcionario funcionario, Model model, RedirectAttributes redirectAttributes) {
		
		
		if(codigoValidacao.equals("12345679")) {
		
	    redirectAttributes.addFlashAttribute("cadastrado", "cadastro sucedido!!");
   
	    mFuncionarioService.salvarFuncionario(funcionario);

	    // Redireciona para a página de cadastro novamente, limpando o formulário
	    return "redirect:CadastrarFuncionario";
		}
		
		String script = "showErrorModal('codigo invalido');";
		model.addAttribute("script", script);

		model.addAttribute("cadastrado", "codigo invalido");
		return "cadastro";
	}
	
	
	
	
	
	
	
	/*
	 * @PostMapping("CadastrarFuncionario")
	public String cadastrarFuncionario(Funcionario funcionario, Model model){
		if(funcionario.getNome().equals("")) {
			model.addAttribute("aviso", "Insira o nome");
			return "cadastro";
		}else if(funcionario.getEmail().equals("")) {
			model.addAttribute("aviso", "Insira o email");
			return "cadastro";
		}else if(funcionario.getCpf().equals("")) {
			model.addAttribute("aviso", "Insira o cpf");
			return "cadastro";
		}else if(funcionario.getSenha().equals("")) {
			model.addAttribute("aviso", "Insira o senha");
			return "cadastro";
		}
		
		mFuncionarioService.salvarFuncionario(funcionario);	
		model.addAttribute("aviso", "Cadastro bem-sucedido");
		return "cadastro";
	}
	*/
	
	
	
	
	
	/*
		@PostMapping("CadastrarFuncionario")
	public ResponseEntity<Funcionario> cadastrarFuncionario( Funcionario funcionario){
		
		Funcionario funcionarioCadastro = mFuncionarioService.salvarFuncionario(funcionario);
		
		return ResponseEntity.ok(funcionarioCadastro);
		
		
	}
	*/
	
	/*
	
	@PostMapping("CadastrarFuncionario")	
	public String form(Funcionario funcionario){
		
		fr.save(funcionario);
		
		return "redirect:CadastrarFuncionario";
		
	}
	
	*/
}
