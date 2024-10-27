package pe.edu.cibertec.lp2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.cibertec.lp2final.model.Alumno;
import pe.edu.cibertec.lp2final.model.Usuario;
import pe.edu.cibertec.lp2final.repository.RolRepository;
import pe.edu.cibertec.lp2final.repository.UsuarioRepository;
import pe.edu.cibertec.lp2final.service.UsuarioServicio;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuariorep;

	@Autowired
	private UsuarioServicio usuarioserv;

	@Autowired
	private RolRepository rolrepo;

	@GetMapping("/login")
	public String loginView(Model model) {
		System.out.println("Mostrando login");
		model.addAttribute("usuarioLogin", new Usuario());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Usuario usuario, Model model) {
		System.out.println("Validando login");
		String redirect = "login";
		Usuario u = usuarioserv.validateUserByEmailAndPassword(usuario.getCorreo(), usuario.getPassword());
		if (u != null) {
			// System.out.println("Actualizando usuario");
			Usuario updUsuario = usuarioserv.updateUserLogin(u);
			model.addAttribute("usuarioLogin", updUsuario);
			redirect = "redirect:/usuario";
		} else {
			model.addAttribute("errors", "Usuario o clave incorrectos");
			model.addAttribute("usuarioLogin", new Usuario());
		}

		return redirect;
	}

	@GetMapping("/registrar")
	public String mostrarRegistro(Model model) {
		model.addAttribute("listaRoles", rolrepo.findAll());
		model.addAttribute("usuario", new Usuario());
		return "usuario_formulario";
	}

	@PostMapping("/registrar/guardar")
	public String guardarUsuario(Usuario usuario, Model model) {
		usuariorep.save(usuario);

		return "redirect:/usuario";
	}

	@GetMapping("/usuario")
	public String listarUsuario(Model model) {
		try {
			model.addAttribute("ltsUsuario", usuariorep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarUsuario";
	}
	
	@GetMapping("/usuario/editar/{id}")
	public String mostrarFormularioDeModificarUsuario(@PathVariable("id") Long id, Model model) {
		
		Usuario usuario = usuariorep.findById(id).get();
		model.addAttribute("usuario" , usuario);
		
		model.addAttribute("listaRoles",  rolrepo.findAll());
		
		return "usuario_formulario";
	}
	
	@GetMapping("/usuario/eliminar/{id}")
	public String eliminarUsuario(@PathVariable("id") Long id) {
		usuariorep.deleteById(id);
	    return "redirect:/usuario";
	}

}
