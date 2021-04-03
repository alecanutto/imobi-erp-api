package com.acanuto.imobi.erp.controller.fiador;

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

import com.acanuto.imobi.erp.dto.fiador.FiadorContaBancariaDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorContaBancaria;
import com.acanuto.imobi.erp.service.fiador.FiadorContaBancariaService;

@RestController
@RequestMapping("/api/fiador_bancos")
public class FiadorContaBancariaController {
	
	@Autowired
	private FiadorContaBancariaService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody FiadorContaBancariaDTO bancoDTO) {
		try {
			return new ResponseEntity<FiadorContaBancaria>(service.save(bancoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/all/{fiadorId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<FiadorContaBancaria> getAllByFiadorId(long fiadorId) {
		return service.getAllByFiadorId(fiadorId);
	}

	@GetMapping("/{fiadorId}")
	public ResponseEntity<?> getByFiadorId(@RequestParam long fiadorId) {
		Optional<FiadorContaBancaria> banco = service.getByFiadorId(fiadorId);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<FiadorContaBancaria>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<FiadorContaBancaria> banco = service.getById(id);
		if (banco.isPresent()) {
			return new ResponseEntity<Optional<FiadorContaBancaria>>(banco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}