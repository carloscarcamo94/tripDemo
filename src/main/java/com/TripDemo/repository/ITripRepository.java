package com.TripDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TripDemo.model.Trip;

public interface ITripRepository extends JpaRepository<Trip, Integer> {
    // JpaRepository ya tiene métodos como findAll(), save(), findById(), deleteById().
	
	// Método para buscar por estatus (para mostrar solo los Activos, opcional pero útil)
    List<Trip> findByEstatus(String estatus);
    
    // 1. Buscar trips que contengan X texto en la descripción
    List<Trip> findByDescripcionContaining(String descripcion);
    
    // 2. Buscar trips que pertenezcan a una categoría específica
    List<Trip> findByCategoriaId(Integer idCategoria);
}