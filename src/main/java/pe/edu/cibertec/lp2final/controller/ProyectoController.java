package pe.edu.cibertec.lp2final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProyectoController {
	
	@GetMapping("/index")
	public String verPaginaDeInicio() {
		return "index";
	}
	
}
