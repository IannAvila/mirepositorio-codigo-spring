package com.formacionspring.hola.service;

import java.util.List;

import com.formacionspring.hola.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> mostrarTodos();
	public Cliente mostrarPorId(Long id);
	public Cliente guardar(Cliente cliente);
	public void borrar(Long id);
	

}
