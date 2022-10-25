
package com.portfolio.Portfolio.Repository;

import com.portfolio.Portfolio.Entity.Hards;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Robles
 */
public interface RHards extends JpaRepository<Hards, Integer>{
    Optional<Hards> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
