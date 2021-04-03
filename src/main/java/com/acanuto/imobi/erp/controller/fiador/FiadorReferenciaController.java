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

import com.acanuto.imobi.erp.dto.fiador.FiadorReferenciaDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorReferencia;
import com.acanuto.imobi.erp.service.fiador.FiadorReferenciaService;

@RestController
@RequestMapping("/api/fiador_referencia")
public class FiadorReferenciaController {
		
	@Autowired
	private FiadorReferenciaService service;
	
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody FiadorReferenciaDTO referenciaDTO) {
		try {
			return new ResponseEntity<FiadorReferencia>(service.save(referenciaDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/all/{fiadorId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<FiadorReferencia> getAllByFiadorId(long fiadorId) {
		return service.getAllByFiadorId(fiadorId);
	}

	@GetMapping("/{fiadorId}")
	public ResponseEntity<?> getByFiadorId(@RequestParam long fiadorId) {
		Optional<FiadorReferencia> referencia = service.getByFiadorId(fiadorId);
		if (referencia.isPresent()) {
			return new ResponseEntity<Optional<FiadorReferencia>>(referencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<FiadorReferencia> referencia = service.getById(id);
		if (referencia.isPresent()) {
			return new ResponseEntity<Optional<FiadorReferencia>>(referencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
