package com.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.app.usuarios.models.entity.Alumno;
import com.microservicios.app.usuarios.services.AlumnoService;

@RestController
public class AlumnoController {
    
    //inyectamos el servicio de alumnos
    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        
        Optional<Alumno> opt = service.findById(id);
        if(opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnoDb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){
        
        Optional<Alumno> opt = service.findById(id);
        if(opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = opt.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deletById(id);
        return ResponseEntity.noContent().build();
    }

}