package com.microservicios.app.usuarios.services;

import org.springframework.stereotype.Service;

import com.microservicios.app.usuarios.models.entity.Alumno;
import com.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.microservicios.commons.service.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {
	
 
}
