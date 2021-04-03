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

import com.acanuto.imobi.erp.dto.imovel.ImovelDocumentosDTO;
import com.acanuto.imobi.erp.model.imovel.ImovelDocumentos;
import com.acanuto.imobi.erp.service.imovel.ImovelDocumentosService;

@RestController
@RequestMapping("/api/imovel_documentos")
public class ImovelDocumentosController {

	@Autowired
	private ImovelDocumentosService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ImovelDocumentosDTO dto) {
		try {
			return new ResponseEntity<ImovelDocumentos>(service.save(dto), HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<ImovelDocumentos> getAll() {
		return service.getAll();
	}

	@GetMapping("/{imovelId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ImovelDocumentos> getAllByImovelId(@RequestParam long imovelId) {
		return service.getAllByImovelId(imovelId);
	}

	@GetMapping("/{categoria}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ImovelDocumentos> getAllByCategoria(@RequestParam String categoria) {
		return service.getAllByCategoria(categoria);
	}

	@GetMapping("/{descricao}")
	public ResponseEntity<?> getByTitulo(@RequestParam String titulo) {
		Optional<ImovelDocumentos> doc = service.getByTitulo(titulo);
		if (doc.isPresent()) {
			return new ResponseEntity<Optional<ImovelDocumentos>>(doc, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<ImovelDocumentos> tipo = service.getById(id);
		if (tipo.isPresent()) {
			return new ResponseEntity<Optional<ImovelDocumentos>>(tipo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deletetById(@RequestParam long id) {
		service.deleteById(id);
	}

}
