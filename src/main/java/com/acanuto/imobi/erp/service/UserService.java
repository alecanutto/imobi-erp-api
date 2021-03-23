package com.acanuto.imobi.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.model.User;
import com.acanuto.imobi.erp.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository repository;

	public void save(User user) throws Exception {
		if (repository.existsByUsername(user.getUsuario())) {
			throw new Exception("Usuário já cadastrado!");
		}

		repository.save(user);

	}

	public Optional<User> getById(long id) {
		return repository.findById(id);
	}

	public Optional<User> getByUsername(String username) {
		return repository.getByUsername(username);
	}

	public List<User> getAll() {
		return repository.getAll();
	}

}
