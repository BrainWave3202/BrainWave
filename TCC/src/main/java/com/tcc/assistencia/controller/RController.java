package com.tcc.assistencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/")
public class RController {
	
	@GetMapping("index")
	public String index(){
		
		return "index";
	}

}
