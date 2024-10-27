package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.cibertec.lp2final.model.Rol;
import pe.edu.cibertec.lp2final.repository.RolRepository;

@Controller
public class RollController {

	@Autowired
	private RolRepository rolrep;
	
	@GetMapping("/rol")
	public String listarRoll(Model model) {
		try {
			model.addAttribute("ltsRol", rolrep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarRol";
	}
	
	@GetMapping("rol/nuevo")
	public String mostrarFormularioDeNuevoRoll(Model model) {
		model.addAttribute("rol", new Rol());
		return "rol_formulario";
	}
	
	@PostMapping("/rol/guardar")
	public String guardarRoll(Rol rol) {
		rolrep.save(rol);
		return "redirect:/rol";
	}
	
	@GetMapping("/rol/editar/{id}")
	public String mostrarFormularioDeModificarRoll(@PathVariable("id") Long id, Model model) {
		
		 System.out.println("ID capturado: " + id);
		
		 Rol rol = rolrep.findById(id).get();
		model.addAttribute("rol", rol);
		
		return "rol_formulario";
	}
	
	@GetMapping("/rol/eliminar/{id}")
	public String eliminarRoll(@PathVariable("id") Long id) {
		rolrep.deleteById(id);
		
		return "redirect:/rol";
	}
	
}
