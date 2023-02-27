package com.portfolio.alex_Project.Security.Service;

import com.portfolio.alex_Project.Security.Entity.Rol;
import com.portfolio.alex_Project.Security.Enums.RolNombre;
import com.portfolio.alex_Project.Security.Repository.iRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save (Rol rol) {
        irolRepository.save(rol);
    }    
}
