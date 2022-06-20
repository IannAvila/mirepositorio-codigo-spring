package com.formacionspring.hola.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.hola.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	
	

}
