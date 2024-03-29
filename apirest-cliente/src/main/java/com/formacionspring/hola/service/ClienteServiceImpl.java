package com.formacionspring.hola.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspring.hola.entity.Cliente;
import com.formacionspring.hola.repository.ClienteDao;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao clienteDao; 

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> mostrarTodos() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente mostrarPorId(Long id) {

		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		
		clienteDao.deleteById(id);
		
	}

}
