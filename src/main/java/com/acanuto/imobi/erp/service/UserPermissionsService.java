package com.acanuto.imobi.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.model.UserPermissions;
import com.acanuto.imobi.erp.repository.UserPermissionsRepository;
import com.acanuto.imobi.erp.repository.UserRepository;

@Component
public class UserPermissionsService {

	@Autowired
	private UserRepository userRepository;  
	
	@Autowired
	private UserPermissionsRepository repository;

	public void save(UserPermissions permission) throws Exception {
		if (!userRepository.existsById(permission.getCodUsuario())) {
			throw new RuntimeException("Usuário não cadastrado!");
		}
		repository.save(permission);
	}
	
	public void saveAll(List<UserPermissions> permissions) throws Exception {
		permissions.forEach((permission) -> {
			if (!repository.existsById(permission.getCodUsuario())) {
				throw new RuntimeException("Usuário não cadastrado!");
			}
		});	
		repository.saveAll(permissions);
	}

	public List<UserPermissions> getAllByUserId(long userId) {
		return repository.getAllByUserId(userId);
	}

}
