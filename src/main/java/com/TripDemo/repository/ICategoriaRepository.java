package com.TripDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TripDemo.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	// Listo, ya tenemos acceso a findAll(), save(), etc. para Categorías
}