package pe.edu.cibertec.lp2final.service;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.lp2final.model.Rol;

public interface RolService {
    List<Rol> findAll(); 
    Optional<Rol> findById(Long id); 
    Rol save(Rol rol); 
}
