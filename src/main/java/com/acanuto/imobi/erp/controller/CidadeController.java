package com.acanuto.imobi.erp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.CidadeDTO;
import com.acanuto.imobi.erp.model.Cidade;
import com.acanuto.imobi.erp.service.CidadeService;

@CrossOrigin
@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

	@Autowired
	private CidadeService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CidadeDTO cidadeDTO) {
		try {
			return new ResponseEntity<Cidade>(service.save(cidadeDTO), HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteById(@RequestParam long id) {
		service.deleteById(id);
	}
	
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Cidade> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/uf")
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getAllUF() {
		return service.getAllUF();
	}
	
	@GetMapping("/cidades")	
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getAllByUf(@RequestParam String uf) {
		return service.getAllByUf(uf);
	}

	@GetMapping("/filtro")
	public ResponseEntity<?> getByUfAndCidade(@RequestParam String cidade, @RequestParam String uf) {
		Cidade cid = service.getByUfAndCidade(uf, cidade);
		if (cidade != null) {
			return new ResponseEntity<Cidade>(cid, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
