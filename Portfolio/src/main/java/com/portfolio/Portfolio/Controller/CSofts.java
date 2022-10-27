package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.dtoSofts;
import com.portfolio.Portfolio.Entity.Softs_Skills;
import com.portfolio.Portfolio.Security.Controller.Mensaje;
import com.portfolio.Portfolio.Service.SSofts;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas Robles
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/sskill")
public class CSofts {

    @Autowired
    SSofts ssofts;

    @GetMapping("/lista")
    public ResponseEntity<List<Softs_Skills>> list() {
        List<Softs_Skills> list = ssofts.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Softs_Skills> getById(@PathVariable("id") int id) {
        if (!ssofts.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Softs_Skills softs = ssofts.getOne(id).get();
        return new ResponseEntity(softs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!ssofts.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        ssofts.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSofts dtosoft) {
        if (StringUtils.isBlank(dtosoft.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ssofts.existsByNombre(dtosoft.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Softs_Skills softs = new Softs_Skills(dtosoft.getNombre(), dtosoft.getPorcentaje());
        ssofts.save(softs);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSofts dtosoft) {
        //Validamos si existe el ID
        if (!ssofts.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (ssofts.existsByNombre(dtosoft.getNombre()) && ssofts.getByNombre(dtosoft.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtosoft.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Softs_Skills softs = ssofts.getOne(id).get();
        softs.setNombre(dtosoft.getNombre());
        softs.setPorcentaje(dtosoft.getPorcentaje());

        ssofts.save(softs);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
