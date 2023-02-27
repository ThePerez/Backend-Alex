package com.portfolio.alex_Project.Controller;


import com.portfolio.alex_Project.Dto.DtoPersona;
import com.portfolio.alex_Project.Entity.Persona;
import com.portfolio.alex_Project.Security.Controller.Mensaje;
import com.portfolio.alex_Project.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://front-alex.web.app","http://localhost:4200"})
public class PersonaController {
    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe este ID"), HttpStatus.BAD_REQUEST);
        }
         Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
/*    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe este ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Educación fué eliminada"), HttpStatus.OK);
    }*/
    
  /*  @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoPersona){
        if(StringUtils.isBlank(dtoPersona.getNombreE())){
            return new ResponseEntity(new Mensaje("El Nombre Es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existsByNombreE(dtoPersona.getNombreE())){
            return new ResponseEntity(new Mensaje("Este Nombre Ya Existe"), HttpStatus.BAD_REQUEST);
        }      
        Educacion educacion = new Educacion(
                dtoPersona.getNombreE(), dtoPersona.getDescripcionE());
        personaService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion fué creada"), HttpStatus.OK);                
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe este ID"), HttpStatus.NOT_FOUND);
    }
        if(personaService.existsByNombre(dtoPersona.getNombre()) && personaService.getByNombre(dtoPersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Este Nombre Ya Existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();      
        
        persona.setNombre(dtoPersona.getNombre());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setApellido(dtoPersona.getApellido());
        persona.setImg(dtoPersona.getImg());
        
        personaService.save(persona);        
        
        return new ResponseEntity(new Mensaje("Persona Fué Actualizada"), HttpStatus.OK);
    }    
    
  }
