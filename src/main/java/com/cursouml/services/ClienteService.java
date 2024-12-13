package com.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursouml.domain.Cliente;
import com.cursouml.repositories.ClienteRepository;
import com.cursouml.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repo;
	
	public Cliente buscar(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
				+ id + " Tipo: " + Cliente.class.getName()));
	}

}
