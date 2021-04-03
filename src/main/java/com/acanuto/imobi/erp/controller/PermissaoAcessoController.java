package com.acanuto.imobi.erp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.model.PermissaoAcesso;
import com.acanuto.imobi.erp.service.PermissaoAcessoService;

@RestController
@RequestMapping("/api/permissao_acesso")
public class PermissaoAcessoController {
	
	@Autowired
	private PermissaoAcessoService service;

	@PostMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> save(@Valid @RequestBody PermissaoAcesso permission) {
		try {
			service.save(permission);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir permissão para o usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Permissão cadastrada com sucesso!"));
	}
	
	@PostMapping(value = "/saveAll")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> saveAll(@Valid @RequestBody List<PermissaoAcesso> permissions) {
		try {
			service.saveAll(permissions);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir permissões para o usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Permissões cadastradas com sucesso!"));
	}
	
	@PutMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> update(@Valid @RequestBody PermissaoAcesso permission) {
		try {
			service.save(permission);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao alterar permissão para o usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Permissão alterada com sucesso!"));
	}

	@PutMapping(value = "/updateAll")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> updateAll(@Valid @RequestBody List<PermissaoAcesso> permissions) {
		try {
			service.saveAll(permissions);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir permissões para o usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Permissões alteradas com sucesso!"));
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getAllByUserId(@RequestParam long usuarioId) {
		List<PermissaoAcesso> permissoes = service.getAllByUserId(usuarioId);
		if (permissoes.size() > 0) {
			return new ResponseEntity<List<PermissaoAcesso>>(permissoes, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
}
