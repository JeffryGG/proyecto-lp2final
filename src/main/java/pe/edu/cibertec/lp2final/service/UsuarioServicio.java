package pe.edu.cibertec.lp2final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.lp2final.model.Usuario;
import pe.edu.cibertec.lp2final.repository.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepository usuariorep;
	
	public Usuario validateUserByEmailAndPassword(String email, String password) {
		Usuario u = usuariorep.findByEmailAndPassword(email, password);
		return u;
	}
	
	public Usuario updateUserLogin(Usuario usuario) {
		//Usuario u = new Usuario(u.getNombre(),u.getApellido())
		return usuariorep.save(usuario);
	}
	
	public void  deleteUserLogin(Usuario usuario) {
		usuariorep.delete(usuario);
	}

}
