
package com.portfolio.Portfolio.Repository;

import com.portfolio.Portfolio.Entity.Softs;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Robles
 */
public interface RSofts extends JpaRepository<Softs, Integer>{
    Optional<Softs> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
