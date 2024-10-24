package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pe.edu.cibertec.lp2final.model.PagoCosto;
import pe.edu.cibertec.lp2final.repository.PagoCostoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PagoCostoController {

	@Autowired
	private PagoCostoRepository pagoCostoRep;
	
	@GetMapping("/pagoporclase")
	public String listarPagosporClase(Model model) {
		try {
			model.addAttribute("ltsPago", pagoCostoRep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarPagosporClase";
	}
	
	
	@GetMapping("pagoporclase/nuevo")
	public String mostrarFormularioDeNuevoPagoporClase(Model model) {
		model.addAttribute("pagos", new PagoCosto());
		return "pago_formulario";
	}
	
	@PostMapping("/pagoporclase/guardar")
	public String guardarPagoporClase(PagoCosto pagocosto) {
		pagoCostoRep.save(pagocosto);
		return "redirect:/pagoporclase";
	}
	
	@GetMapping("/pagoporclase/editar/{idpago}")
	public String mostrarFormularioDeModificarPagos(@PathVariable("idpago") Integer idpago, Model model) {
		
		 System.out.println("ID capturado: " + idpago);
		
		PagoCosto pagos = pagoCostoRep.findById(idpago).get();
		model.addAttribute("pagos", pagos);
		
		return "pago_formulario";
	}
	
	@GetMapping("/pagoporclase/eliminar/{idpago}")
	public String eliminarPago(@PathVariable("idpago") Integer idpago) {
		pagoCostoRep.deleteById(idpago);
		
		return "redirect:/pagoporclase";
	}
	
}
