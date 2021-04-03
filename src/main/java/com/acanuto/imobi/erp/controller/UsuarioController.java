package com.acanuto.imobi.erp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.model.Usuario;
import com.acanuto.imobi.erp.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@CrossOrigin
	@PostMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario) {
		try {
			service.save(usuario);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir usuário." + System.lineSeparator() + e.getMessage());
		}
		return ResponseEntity.ok(new String("Usuário cadastrado com sucesso!"));
	}
	
	@CrossOrigin
	@PutMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario) {
		try {
			service.save(usuario);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao alterar usuário." + System.lineSeparator() + e.getMessage());
		}
		return ResponseEntity.ok(new String("Usuário alterado com sucesso!"));
	}

	@CrossOrigin
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Usuario> getAll() {
		return service.getAll();
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Usuario> usuario = service.getById(id);
		if (usuario.isPresent()) {
			return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getByUsername(@RequestParam String username) {
		Optional<Usuario> usuario = service.getByUsername(username);
		if (usuario.isPresent()) {
			return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}