package com.acanuto.imobi.erp.controller;

import java.util.List;

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

import com.acanuto.imobi.erp.model.UserPermissions;
import com.acanuto.imobi.erp.service.UserPermissionsService;

@RestController
@RequestMapping("/api/user_permissions")
public class UserPermissionsController {

	
	@Autowired
	private UserPermissionsService service;

	@PostMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> save(@Valid @RequestBody UserPermissions permission) {
		try {
			service.save(permission);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir permissão para o usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Permissões cadastrado com sucesso!"));
	}

	@PostMapping(value = "/saveAll")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> saveAll(@Valid @RequestBody List<UserPermissions> permissions) {
		try {
			service.saveAll(permissions);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao incluir permissões para o usuário." + System.lineSeparator() + e.getMessage());
		}

		return ResponseEntity.ok(new String("Permissões cadastradas com sucesso!"));
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getAllByUserId(@RequestParam long userId) {
		List<UserPermissions> permissions = service.getAllByUserId(userId);
		if (permissions.size() > 0) {
			return new ResponseEntity<List<UserPermissions>>(permissions, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
