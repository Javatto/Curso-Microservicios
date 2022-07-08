package com.microservicios.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservicios.commons.service.CommonService;

public class CommonController<E,S extends CommonService<E>> {
    
    @Autowired
    protected S service;

    //** ruta / y llamamos al servicio que lista todo*/ 
    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    //** ruta /id en donde E representa la entidad dada desde cualquier modelo y lo busca*/
    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){ 
        Optional<E> opt = service.findById(id);
        if(opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(opt.get());
    }

    //** ruta / obtenemos la entidad en entity y lo guardamos en la base de datos */
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody E entity){
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    //* ruta /id  llamamos al servicio de eliminar por id*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deletById(id);
        return ResponseEntity.noContent().build();
    }

}
