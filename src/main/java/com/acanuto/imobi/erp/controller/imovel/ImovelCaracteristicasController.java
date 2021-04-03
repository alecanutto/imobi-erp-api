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

import com.acanuto.imobi.erp.dto.imovel.ImovelCaracteristicasDTO;
import com.acanuto.imobi.erp.model.imovel.ImovelCaracteristicas;
import com.acanuto.imobi.erp.service.imovel.ImovelCaracteristicasService;

@RestController
@RequestMapping("/api/imovel_caracteristicas")
public class ImovelCaracteristicasController {

	@Autowired
	private ImovelCaracteristicasService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ImovelCaracteristicasDTO dto) {
		try {
			return new ResponseEntity<ImovelCaracteristicas>(service.save(dto), HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<ImovelCaracteristicas> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{imovelId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ImovelCaracteristicas> getAll(@RequestParam long imovelId) {
		return service.getAllByImovelId(imovelId);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ImovelCaracteristicas> carac = service.getById(id);
		if (carac.isPresent()) {
			return new ResponseEntity<Optional<ImovelCaracteristicas>>(carac, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deletetById(@RequestParam long id) {
		service.deleteById(id);
	}
	
}
