package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pe.edu.cibertec.lp2final.model.Talleres;
import pe.edu.cibertec.lp2final.repository.TallerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TalleresController {
	
	@Autowired
	private TallerRepository tallerrep;
	
	@GetMapping("/taller")
	public String listarTaller(Model model) {
		try {
			model.addAttribute("ltsTaller", tallerrep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarTaller";
	}
	
	@GetMapping("taller/nuevo")
	public String mostrarFormularioDeNuevoTaller(Model model) {
		model.addAttribute("taller", new Talleres());
		return "taller_formulario";
	}
	
	@PostMapping("/taller/guardar")
	public String guardarTaller(Talleres taller) {
		tallerrep.save(taller);
		return "redirect:/taller";
	}
	
	@GetMapping("/taller/editar/{idtaller}")
	public String mostrarFormularioDeModificarTaller(@PathVariable("idtaller") Integer idtaller, Model model) {
		
		 System.out.println("ID capturado: " + idtaller);
		
		 Talleres taller = tallerrep.findById(idtaller).get();
		model.addAttribute("taller", taller);
		
		return "taller_formulario";
	}
	
	@GetMapping("/taller/eliminar/{idtaller}")
	public String eliminarTaller(@PathVariable("idtaller") Integer idtaller) {
		tallerrep.deleteById(idtaller);
		
		return "redirect:/taller";
	}

}
