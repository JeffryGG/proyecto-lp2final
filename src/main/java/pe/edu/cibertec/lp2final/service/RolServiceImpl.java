package pe.edu.cibertec.lp2final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.lp2final.model.Rol;
import pe.edu.cibertec.lp2final.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {
	
	private final RolRepository rolrep;

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolrep = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolrep.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolrep.findById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolrep.save(rol);
    }

}
