package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.cibertec.lp2final.model.Salario;
import pe.edu.cibertec.lp2final.repository.SalarioRepository;

@Controller
public class SalarioController {

	@Autowired
	private SalarioRepository salariorep;
	
	@GetMapping("/salario")
	public String listarSalario(Model model) {
		try {
			model.addAttribute("ltsSalario", salariorep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarSalario";
	}
	
	@GetMapping("salario/nuevo")
	public String mostrarFormularioDeNuevoSalario(Model model) {
		model.addAttribute("salario", new Salario());
		return "salario_formulario";
	}
	
	@PostMapping("/salario/guardar")
	public String guardarSalario(Salario salario) {
		salariorep.save(salario);
		return "redirect:/salario";
	}
	
	@GetMapping("/salario/editar/{idsalario}")
	public String mostrarFormularioDeModificarSalarios(@PathVariable("idsalario") Integer idsalario, Model model) {
		
		 System.out.println("ID capturado: " + idsalario);
		
		 Salario salario = salariorep.findById(idsalario).get();
		model.addAttribute("salario", salario);
		
		return "salario_formulario";
	}
	
	@GetMapping("/salario/eliminar/{idsalario}")
	public String eliminarSalario(@PathVariable("idsalario") Integer idsalario) {
		salariorep.deleteById(idsalario);
		
		return "redirect:/salario";
	}
	
}
