
package com.portfolio.alex_Project.Repository;

import com.portfolio.alex_Project.Entity.Hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHys extends JpaRepository<Hys, Integer>{
    Optional<Hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
