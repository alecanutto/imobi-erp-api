package com.acanuto.imobi.erp.controller.imovel;

import java.util.Date;
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

import com.acanuto.imobi.erp.dto.imovel.ImovelDTO;
import com.acanuto.imobi.erp.enums.Enums.EnumFinalidadeImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumOcupacaoImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumSituacaoImovel;
import com.acanuto.imobi.erp.model.imovel.Imovel;
import com.acanuto.imobi.erp.service.imovel.ImovelService;

@RestController
@RequestMapping("/api/imovel")
public class ImovelController {

	@Autowired
	private ImovelService service;

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ImovelDTO dto) {
		try {
			return new ResponseEntity<Imovel>(service.save(dto), HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAll() {
		return service.getAll();
	}

	@GetMapping("/{titulo}")
	public ResponseEntity<?> getByTitulo(@RequestParam String titulo) {
		Optional<Imovel> imovel = service.getByTituloStartingWith(titulo);
		if (imovel.isPresent()) {
			return new ResponseEntity<Optional<Imovel>>(imovel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Imovel> tipo = service.getById(id);
		if (tipo.isPresent()) {
			return new ResponseEntity<Optional<Imovel>>(tipo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deletetById(@RequestParam long id) {
		service.deleteById(id);
	}
	
	@GetMapping("/{finalidade}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAllByFinalidade(@RequestParam EnumFinalidadeImovel finalidade) {
		return service.getAllByFinalidade(finalidade);
	}

	@GetMapping("/{situacao}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAllBySituacao(@RequestParam EnumSituacaoImovel situacao) {
		return service.getAllBySituacao(situacao);
	}
	
	@GetMapping("/{ocupacao}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAllByOcupacao(@RequestParam EnumOcupacaoImovel ocupacao) {
		return service.getAllByOcupacao(ocupacao);
	}
	
	@GetMapping("/{tipoImovelId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAllByTipoImovelId(@RequestParam long tipoImovelId) {
		return service.getAllByImovelTipoId(tipoImovelId);
	}
	
	@GetMapping("/{dataCadastro}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAllByDataCadastro(@RequestParam Date dataInicial, Date dataFinal) {
		return service.getAllByDataCadastroBetween(dataInicial, dataFinal);
	}
	
	@GetMapping("/{dataCaptacao}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Imovel> getAllByDataCaptacao(@RequestParam Date dataInicial, Date dataFinal) {
		return service.getAllByDataCaptacaoBetween(dataInicial, dataFinal);
	}

}