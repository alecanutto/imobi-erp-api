package com.acanuto.imobi.erp.controller;

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

import com.acanuto.imobi.erp.dto.PlanoContasDTO;
import com.acanuto.imobi.erp.model.PlanoContas;
import com.acanuto.imobi.erp.service.PlanoContasService;

@RestController
@RequestMapping("/api/plano_contas")
public class PlanoContasController {

	@Autowired
	private PlanoContasService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody PlanoContasDTO pContasDTO) {
		try {
			return new ResponseEntity<PlanoContas>(service.save(pContasDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}
	
	@GetMapping("/{maxGrupo}")
	@ResponseStatus(value = HttpStatus.OK)
	public String getMaxGrupo() {
		try {
			return service.getMaxGrupo();
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getMessage());
		}
	}
	
	@GetMapping("/{maxCodigo}")
	@ResponseStatus(value = HttpStatus.OK)
	public String getMaxGrupo(@RequestBody String grupo) {
		try {
			return service.getMaxCodigo(grupo);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getMessage());
		}
	}

	@GetMapping("/{tipo}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<PlanoContas> getAllByTipo(@RequestParam int tipo) {
		return service.getAllByTipo(tipo);
	}

	@GetMapping("/{grupo}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<PlanoContas> getAllByGrupo(@RequestParam String grupo) {
		return service.getAllByGrupo(grupo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> getByCodigo(@RequestParam String codigo) {
		Optional<PlanoContas> pContas = service.getByCodigo(codigo);
		if (pContas.isPresent()) {
			return new ResponseEntity<Optional<PlanoContas>>(pContas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{descricao}")
	public ResponseEntity<?> getByDescricao(@RequestParam String descricao) {
		Optional<PlanoContas> pContas = service.getByDescricao(descricao);
		if (pContas.isPresent()) {
			return new ResponseEntity<Optional<PlanoContas>>(pContas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
