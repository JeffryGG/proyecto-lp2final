package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pe.edu.cibertec.lp2final.model.Alumno;
import pe.edu.cibertec.lp2final.repository.AlumnoRepository;
import pe.edu.cibertec.lp2final.repository.PagoCostoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AlumnoController {

	
	@Autowired
	private AlumnoRepository alumnorep;
	
	@Autowired
	private PagoCostoRepository pagorep;
	
	@GetMapping("/alumnos")
	public String listarAlumnos(Model model) {
		try {
			model.addAttribute("ltsAlumno", alumnorep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarAlumnos";
	}
	
	@GetMapping("alumnos/nuevo")
	public String mostrarFormularioDeNuevoAlumno(Model model) {
		
		model.addAttribute("listaClases",  pagorep.findAll());
		model.addAttribute("alumno" , new Alumno());
		
		
		return "alumno_formulario";
	}
	
	@PostMapping("/alumnos/guardar")
	public String guardarAlumno(Alumno alumno) {
		alumnorep.save(alumno);
		
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/editar/{idalumno}")
	public String mostrarFormularioDeModificarAlumno(@PathVariable("idalumno") Integer idalumno, Model model) {
		
		Alumno alumno = alumnorep.findById(idalumno).get();
		model.addAttribute("alumno" , alumno);
		
		model.addAttribute("listaClases",  pagorep.findAll());
		
		return "alumno_formulario";
	}
	
	@GetMapping("/alumnos/eliminar/{idalumno}")
	public String eliminarAlumno(@PathVariable("idalumno") Integer idalumno) {
	    alumnorep.deleteById(idalumno);
	    return "redirect:/alumnos";
	}

	
	
}
