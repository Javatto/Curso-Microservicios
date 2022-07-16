package com.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.app.usuarios.services.AlumnoService;
import com.microservicios.commons.alumnos.commonsalumnos.models.entity.Alumno;
import com.microservicios.commons.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno,AlumnoService>{

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){
        
        Optional<Alumno> opt = this.service.findById(id);
        if(opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = opt.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @GetMapping("/filtrar/{texto}")
    public ResponseEntity<?> filtrar(@PathVariable String texto){
        return ResponseEntity.ok(service.findByNombreOrApellido(texto));
    }

}
