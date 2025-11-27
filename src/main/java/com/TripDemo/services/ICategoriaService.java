package com.TripDemo.services;

import java.util.List;

import com.TripDemo.model.Categoria;

public interface ICategoriaService {

	List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
    void eliminar(Integer idCategoria);
}