package com.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservicios.commons.alumnos.commonsalumnos.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno,Long>{
    
    @Query("SELECT a FROM Alumno a where a.nombre like %?1% or a.apellido like %?1%")
    public List<Alumno>  findByNombreOrApellido(String texto);
}
