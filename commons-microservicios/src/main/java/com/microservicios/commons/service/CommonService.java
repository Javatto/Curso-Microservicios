package com.microservicios.commons.service;

import java.util.Optional;

public interface CommonService<E> {

    //** funcion que itera en clases tipo E y las encuentra todas  */
    public Iterable<E> findAll();
    
    //** funcion que nos dice si una entidad esta en la base de datos */
    public Optional<E> findById(Long id);
    
    //** funcion que guarda una entidad E en la base de datos */
    public E save(E entity);

    //** funcion que elimina por un ID */
    public void deletById(Long id);
}
