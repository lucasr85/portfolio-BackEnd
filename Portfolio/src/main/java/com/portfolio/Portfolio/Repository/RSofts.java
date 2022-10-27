
package com.portfolio.Portfolio.Repository;

import com.portfolio.Portfolio.Entity.Softs_Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Robles
 */
public interface RSofts extends JpaRepository<Softs_Skills, Integer>{
    Optional<Softs_Skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
