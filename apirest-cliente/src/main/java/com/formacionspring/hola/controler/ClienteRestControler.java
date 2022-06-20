package com.formacionspring.hola.controler;

import java.util.List;

import javax.swing.text.AttributeSet.ParagraphAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspring.hola.entity.Cliente;
import com.formacionspring.hola.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestControler {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping({"/clientes","/"})
	public List<Cliente> index() {
		return servicio.mostrarTodos();
		
	} 
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable long id) {
		return servicio.mostrarPorId(id);
	}
	
	@PostMapping("/clientes")
	public Cliente create(@RequestBody Cliente cliente) {
		return servicio.guardar(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id){
		
		Cliente clienteUpdate=servicio.mostrarPorId(id);
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		
		clienteUpdate.setCreateAt(cliente.getCreateAt());
		
		return servicio.guardar(clienteUpdate);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable long id) {
		servicio.borrar(id);
	}

}
