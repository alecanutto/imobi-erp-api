package com.acanuto.imobi.erp.controller.imovel;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.imovel.ImovelTipoDTO;
import com.acanuto.imobi.erp.model.imovel.ImovelTipo;
import com.acanuto.imobi.erp.service.imovel.ImovelTipoService;

@RestController
@RequestMapping("/api/imovel_tipo")
public class ImovelTipoController {

	@Autowired
	private ImovelTipoService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ImovelTipoDTO dto) {
		try {
			return new ResponseEntity<ImovelTipo>(service.save(dto), HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<ImovelTipo> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ImovelTipo> tipo = service.getById(id);
		if (tipo.isPresent()) {
			return new ResponseEntity<Optional<ImovelTipo>>(tipo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteById(@RequestParam long id) {
		service.deleteById(id);
	}

}