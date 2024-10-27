package pe.edu.cibertec.lp2final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.lp2final.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.correo = ?1 AND u.password = ?2")
	Usuario findByEmailAndPassword(String emailAddress, String password);
	
	
}
