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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.model.User;
import com.acanuto.imobi.erp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@CrossOrigin
	@PostMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> save(@Valid @RequestBody User user) {
		try {
			service.save(user);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Usuário cadastrado com sucesso!"));
	}

	@CrossOrigin
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<User> getAll() {
		return service.getAll();
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<User> user = service.getById(id);
		if (user.isPresent()) {
			return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getByUsername(@RequestParam String username) {
		Optional<User> user = service.getByUsername(username);
		if (user.isPresent()) {
			return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}