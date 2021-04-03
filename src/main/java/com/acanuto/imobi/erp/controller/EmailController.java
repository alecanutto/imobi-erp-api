package com.acanuto.imobi.erp.controller;

import java.util.ArrayList;
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

import com.acanuto.imobi.erp.dto.EmailDTO;
import com.acanuto.imobi.erp.model.Email;
import com.acanuto.imobi.erp.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private EmailService service;

	@CrossOrigin
	@PostMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> save(@Valid @RequestBody EmailDTO email) {
		try {
			service.save(email);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar registro." + System.lineSeparator() + e.getMessage());
		}
		return ResponseEntity.ok(new String("Operação realizada com sucesso!"));
	}
	
	@CrossOrigin
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Email> getAll() {
		List<Email> emails = new ArrayList<>();
		service.getAll().forEach(emails::add);
		return emails;
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Email> email = service.getById(id);
		if (email.isPresent()) {
			return new ResponseEntity<Optional<Email>>(email, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
