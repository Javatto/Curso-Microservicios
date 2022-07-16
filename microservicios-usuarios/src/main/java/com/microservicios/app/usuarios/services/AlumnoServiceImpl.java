package com.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.microservicios.commons.alumnos.commonsalumnos.models.entity.Alumno;
import com.microservicios.commons.service.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String texto) {
        return repository.findByNombreOrApellido(texto);
    }
	
 
}
