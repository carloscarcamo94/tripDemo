package com.TripDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TripDemo.model.Categoria;
import com.TripDemo.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaRepository categoriaRepo;
	
	@Override
	public List<Categoria> buscarTodas() {
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriaRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		categoriaRepo.save(categoria);
	}
	
	@Override
    public void eliminar(Integer idCategoria) {
        categoriaRepo.deleteById(idCategoria);
    }

}