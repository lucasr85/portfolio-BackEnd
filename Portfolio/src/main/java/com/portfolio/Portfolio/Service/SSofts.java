
package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Entity.Softs_Skills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Portfolio.Repository.RSofts;

/**
 *
 * @author Lucas Robles
 */
@Transactional
@Service
public class SSofts {
    @Autowired
    RSofts rsofts;
    
    public List<Softs_Skills> list(){
        return rsofts.findAll();
    }
    
    public Optional<Softs_Skills> getOne(int id){
        return rsofts.findById(id);
    }
    
    public Optional<Softs_Skills> getByNombre(String nombre){
        return rsofts.findByNombre(nombre);
    }
    
    public void save(Softs_Skills skill){
        rsofts.save(skill);
    }
    
    public void delete(int id){
        rsofts.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rsofts.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rsofts.existsByNombre(nombre);
    }
}
