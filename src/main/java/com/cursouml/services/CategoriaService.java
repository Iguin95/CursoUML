package com.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursouml.domain.Categoria;
import com.cursouml.repositories.CategoriaRepository;
import com.cursouml.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	public Categoria buscar(Integer id){
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
				+ id + "Tipo: " + Categoria.class.getName()));
	}

}
