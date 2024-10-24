package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.cibertec.lp2final.model.Profesor;
import pe.edu.cibertec.lp2final.repository.ProfesorRepository;
import pe.edu.cibertec.lp2final.repository.SalarioRepository;

@Controller
public class ProfesorController {

	@Autowired
	private ProfesorRepository profesorrep;
	
	@Autowired
	private SalarioRepository salariorep;
	
	@GetMapping("/profesor")
	public String listarProfesor(Model model) {
		try {
			model.addAttribute("ltsProfesor", profesorrep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarProfesor";
	}
	
	@GetMapping("profesor/nuevo")
	public String mostrarFormularioDeNuevoProfesor(Model model) {
		
		model.addAttribute("ltsSalario",  salariorep.findAll());
		model.addAttribute("profesor" , new Profesor());
		
		
		return "profesor_formulario";
	}
	
	@PostMapping("/profesor/guardar")
	public String guardarProfesor(Profesor profesor) {
		profesorrep.save(profesor);
		
		return "redirect:/profesor";
	}
	
	@GetMapping("/profesor/editar/{idprofesor}")
	public String mostrarFormularioDeModificarAlumno(@PathVariable("idprofesor") Integer idprofesor, Model model) {
		
		Profesor profesor = profesorrep.findById(idprofesor).get();
		model.addAttribute("profesor" , profesor);
		
		model.addAttribute("ltsSalario",  salariorep.findAll());
		
		return "profesor_formulario";
	}
	
	@GetMapping("/profesor/eliminar/{idprofesor}")
	public String eliminarEliminar(@PathVariable("idprofesor") Integer idprofesor) {
		profesorrep.deleteById(idprofesor);
	    return "redirect:/profesor";
	}
}
