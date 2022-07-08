package com.microservicios.app.usuarios.services;

import java.util.List;

import com.microservicios.commons.alumnos.commonsalumnos.models.entity.Alumno;
import com.microservicios.commons.service.CommonService;

public interface AlumnoService extends CommonService<Alumno>{

    public List<Alumno>  findByNombreOrApellido(String texto);
}
