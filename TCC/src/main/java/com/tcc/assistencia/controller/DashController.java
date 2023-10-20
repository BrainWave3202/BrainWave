package com.tcc.assistencia.controller;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcc.assistencia.model.entity.Funcionario;
import com.tcc.assistencia.model.entity.Servico;
import com.tcc.assistencia.model.entity.ServicoForm;
import com.tcc.assistencia.model.service.FuncionarioService;
import com.tcc.assistencia.model.service.ServicoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("api/v1/")
public class DashController {
	
	@Autowired
	private FuncionarioService mFuncionarioService;
	
	@Autowired
	private ServicoService mServicoService;
	
	
	@GetMapping("Servicos_previa")
	public String servicosPrevia(Model model, HttpSession session){
		Funcionario authenticatedUser = (Funcionario) session.getAttribute("authenticatedUser");
		 if (authenticatedUser == null) {
			 
			    return "redirect:login";	 
		 }
		Servico servicosAnalise = mServicoService.procurarServiçoPorDataMaisAntigaDeEmissao(1);
		Servico servicosAndamento = mServicoService.procurarServiçoPorDataMaisAntigaDeEmissao(2);
		

		

		if(servicosAnalise != null) {
		if(servicosAnalise.getImagem() != null) {
		String imagemBase64Analise = Base64.getEncoder().encodeToString(servicosAnalise.getImagem());
		servicosAnalise.setImagemBase64("data:image/png;base64," + imagemBase64Analise);
		}
		
			model.addAttribute("servicoAnalise", servicosAnalise);
		} 
		
		if(servicosAndamento != null) {
			if(servicosAndamento.getImagem() != null) {
			String imagemBase64Andamento = Base64.getEncoder().encodeToString(servicosAndamento.getImagem());
			servicosAndamento.setImagemBase64("data:image/png;base64," + imagemBase64Andamento);
			}
			
			model.addAttribute("servicoAndamento", servicosAndamento);
		} 
		
		
	
		
		System.out.println("oiii");
		
		return "servicos_previa";
	}
	
	

	
	@GetMapping("Servicos_analise")
	public String servicosAnalise(Model model, HttpSession session){
		
		Funcionario authenticatedUser = (Funcionario) session.getAttribute("authenticatedUser");
		 if (authenticatedUser == null) {
			 
			    return "redirect:login";	 
		 }
		List<Servico> servicosAnalise = mServicoService.procurarServiçoEstado(1);
		List<Servico> servicosImparAnalise = new ArrayList<>();
		List<Servico> servicosParAnalise = new ArrayList<>();
		
		
		for(int i = 0;i < servicosAnalise.size();i++ ) {
			if(servicosAnalise.get(i).getImagem() != null) {
			String imagemBase64 = Base64.getEncoder().encodeToString(servicosAnalise.get(i).getImagem());
			servicosAnalise.get(i).setImagemBase64("data:image/png;base64," + imagemBase64);
			}
			if(i % 2 == 0) {
			
				servicosParAnalise.add(servicosAnalise.get(i));
				
			}else {
				
				servicosImparAnalise.add(servicosAnalise.get(i));
			}
					
			
			
		}
		
		
		if(servicosParAnalise != null) {
		model.addAttribute("servicosPar", servicosParAnalise);
		
		}
		
		
		
		if(servicosImparAnalise != null) {
		model.addAttribute("servicosImpar", servicosImparAnalise);
		
		}
		
		
		
	
		
		
	
		
	
		return "servicos_analise";
	}
	
	@GetMapping("Servicos_andamento")
	public String servicosAndamento(Model model, HttpSession session){
		
		Funcionario authenticatedUser = (Funcionario) session.getAttribute("authenticatedUser");
		 if (authenticatedUser == null) {
			 
			    return "redirect:login";	 
		 }
		
		List<Servico> servicosAndamento = mServicoService.procurarServiçoEstado(2);
		List<Servico> servicosImparAndamento = new ArrayList<>();
		List<Servico> servicosParAndamento = new ArrayList<>();
		
		for(int i = 0;i < servicosAndamento.size();i++ ) {
			if(servicosAndamento.get(i).getImagem() != null) {
			String imagemBase64 = Base64.getEncoder().encodeToString(servicosAndamento.get(i).getImagem());
			servicosAndamento.get(i).setImagemBase64("data:image/png;base64," + imagemBase64);
			}
			if(i % 2 == 0) {
			
				servicosParAndamento.add(servicosAndamento.get(i));
				
			}else {
				
				servicosImparAndamento.add(servicosAndamento.get(i));
			}
					
				
			
		}
		
		
		if(servicosParAndamento != null) {
		model.addAttribute("servicosPar", servicosParAndamento);
		
		}
		
		
		
		if(servicosImparAndamento != null) {
		model.addAttribute("servicosImpar", servicosImparAndamento);
		
		}
		
		
		
	
		
		
	
		
	
		return "servicos_andamento";
	}
	
	@GetMapping("teste")
	public String teste(Model model) {
		 List<Funcionario> funcionariosImpar = mFuncionarioService.ListarFuncionarioImpar();
		 List<Funcionario> funcionariosPar = mFuncionarioService.ListarFuncionarioPar();
	     model.addAttribute("funcionariosImpar", funcionariosImpar);
	     model.addAttribute("funcionariosPar", funcionariosPar);
	     return "teste";
	}
	
	@GetMapping("ServicoInf")
	public String servicoInf(Model model, @RequestParam("seuCampo") Long valor,  ServicoForm servicoForm, HttpSession session) {
		Funcionario authenticatedUser = (Funcionario) session.getAttribute("authenticatedUser");
		 if (authenticatedUser == null) {
			 
			    return "redirect:login";	 
		 }
		
		Servico servicoid = mServicoService.listarPorId(valor);
		if(servicoid.getImagem() !=  null) {
		String imagemBase64 = Base64.getEncoder().encodeToString(servicoid.getImagem());
		servicoid.setImagemBase64("data:image/png;base64," + imagemBase64);
		}
		model.addAttribute("Service", servicoid);
		
		return "especificacoes_analise";
	}

	@GetMapping("ServicoInfAndamento")
	public String servicoInfAndamento(Model model, @RequestParam("seuCampo") Long valor,  Servico servico, HttpSession session) {
		
		Funcionario authenticatedUser = (Funcionario) session.getAttribute("authenticatedUser");
		 if (authenticatedUser == null) {
			 
			    return "redirect:login";	 
		 }
		
		Servico servicoid = mServicoService.listarPorId(valor);
		if(servicoid.getImagem() !=  null) {
		String imagemBase64 = Base64.getEncoder().encodeToString(servicoid.getImagem());
		servicoid.setImagemBase64("data:image/png;base64," + imagemBase64);
		}
		model.addAttribute("Service", servicoid);
		
		return "especificacoes_aprovado";
	}
	
	

	
	@PostMapping("ServicoInf")
	public String servicoInfOrcamentos(Model model, ServicoForm servicoForm) {
		
		System.out.println("oiii");
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
        if (servicoForm.getImagem() != null && !servicoForm.getImagem().isEmpty()) {
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
		
		
		return "redirect:Servicos_analise";
	}
	

	
	@PostMapping("ServicoInfAndamento")
	public String servicoInfAndamentoFinalizar(Model model, Servico servico) {
		
		System.out.println("oiii");
	
      
		
		mServicoService.atualizarServico(servico);
		
		
		return "redirect:Servicos_analise";
	}
	
	
}
