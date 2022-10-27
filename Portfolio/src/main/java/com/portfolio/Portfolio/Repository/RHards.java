
package com.portfolio.Portfolio.Repository;

import com.portfolio.Portfolio.Entity.Hards_Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Robles
 */
public interface RHards extends JpaRepository<Hards_Skills, Integer>{
    Optional<Hards_Skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
