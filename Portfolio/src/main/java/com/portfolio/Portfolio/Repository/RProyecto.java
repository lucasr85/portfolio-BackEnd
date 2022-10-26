
package com.portfolio.Portfolio.Repository;

import com.portfolio.Portfolio.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Robles
 */
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
