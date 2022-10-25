
package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Entity.Hards;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Portfolio.Repository.RHards;

/**
 *
 * @author Lucas Robles
 */
@Transactional
@Service
public class SHards {
    @Autowired
    RHards rhards;
    
    public List<Hards> list(){
        return rhards.findAll();
    }
    
    public Optional<Hards> getOne(int id){
        return rhards.findById(id);
    }
    
    public Optional<Hards> getByNombre(String nombre){
        return rhards.findByNombre(nombre);
    }
    
    public void save(Hards skill){
        rhards.save(skill);
    }
    
    public void delete(int id){
        rhards.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhards.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhards.existsByNombre(nombre);
    }
}
