package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.dtoHards;
import com.portfolio.Portfolio.Entity.Hards_Skills;
import com.portfolio.Portfolio.Security.Controller.Mensaje;
import com.portfolio.Portfolio.Service.SHards;
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
@CrossOrigin(origins = "https://frontendportfoliorobles.web.app")

@RequestMapping("/hskill")
public class CHards {

    @Autowired
    SHards shards;

    @GetMapping("/lista")
    public ResponseEntity<List<Hards_Skills>> list() {
        List<Hards_Skills> list = shards.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hards_Skills> getById(@PathVariable("id") int id) {
        if (!shards.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hards_Skills hards = shards.getOne(id).get();
        return new ResponseEntity(hards, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shards.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shards.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHards dtohard) {
        if (StringUtils.isBlank(dtohard.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shards.existsByNombre(dtohard.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Hards_Skills hard = new Hards_Skills(dtohard.getNombre(), dtohard.getPorcentaje());
        shards.save(hard);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHards dtohard) {
        //Validamos si existe el ID
        if (!shards.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (shards.existsByNombre(dtohard.getNombre()) && shards.getByNombre(dtohard.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohard.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Hards_Skills hard = shards.getOne(id).get();
        hard.setNombre(dtohard.getNombre());
        hard.setPorcentaje(dtohard.getPorcentaje());

        shards.save(hard);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
