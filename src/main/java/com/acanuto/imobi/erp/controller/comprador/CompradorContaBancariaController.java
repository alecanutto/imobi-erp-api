package com.acanuto.imobi.erp.controller.comprador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.comprador.CompradorContaBancariaDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorContaBancaria;
import com.acanuto.imobi.erp.service.comprador.CompradorContaBancariaService;

@RestController
@RequestMapping("/api/comprador_bancos")
public class CompradorContaBancariaController {
	
	@Autowired
	private CompradorContaBancariaService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CompradorContaBancariaDTO bancoDTO) {
		try {
			return new ResponseEntity<CompradorContaBancaria>(service.save(bancoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/all/{compradorId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<CompradorContaBancaria> getAllByCompradorId(long compradorId) {
		return service.getAllByCompradorId(compradorId);
	}

	@GetMapping("/{compradorId}")
	public ResponseEntity<?> getByCompradorId(@RequestParam long compradorId) {
		Optional<CompradorContaBancaria> banco = service.getByCompradorId(compradorId);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<CompradorContaBancaria>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<CompradorContaBancaria> banco = service.getById(id);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<CompradorContaBancaria>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}