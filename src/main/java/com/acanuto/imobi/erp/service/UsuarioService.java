package com.acanuto.imobi.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.model.Usuario;
import com.acanuto.imobi.erp.repository.UsuarioRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;

@Component
public class UsuarioService {

	@Autowired
	private ManipulateDB db;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UsuarioRepository repository;

	public void save(Usuario usuario) throws Exception {

		if (usuario == null) {
			throw new Exception("Dados do usuário não informado!");
		}

		if (repository.existsByLogin(usuario.getLogin())) {
			throw new Exception("Usuário já cadastrado!");
		}
		
		String passwordCript = encoder.encode(usuario.getSenha());
		usuario.setSenha(passwordCript);
		Usuario user = new Usuario(0, usuario.getFuncionarioId(), usuario.getLogin(), usuario.getSenha(), usuario.isAtivo());

		repository.save(user);
	}

	public void update(Usuario usuario) throws Exception {

		if (usuario == null) {
			throw new Exception("Dados do usuário não informado!");
		}
		
		if (repository.existsById(usuario.getId())) {
			throw new Exception("Usuário não cadastrado!");
		}

		if (StringUtils.hasText(usuario.getLogin()) && StringUtils.hasText(usuario.getSenha())) {
			if ((boolean) db.getField("select exists (select id from tb_usuarios where id <> "
					+ usuario.getId() + " and login = '" + usuario.getLogin() + "');")) {
				throw new Exception("Login já cadastrado!");
			}
			
			String passwordCript = encoder.encode(usuario.getSenha());
			usuario.setSenha(passwordCript);
			Usuario user = new Usuario(0, usuario.getFuncionarioId(), usuario.getLogin(), usuario.getSenha(), usuario.isAtivo());
			
			repository.save(user);
			
		} else {
			throw new Exception("Dados do usuário inválido!");
		}
	
	}	

	public boolean existsById(long id) {
		return repository.existsById(id);
	}

	public boolean existsByLogin(String login) {
		return repository.existsByLogin(login);
	}
	
	public Optional<Usuario> getById(long id) {
		return repository.findById(id);
	}

	public Optional<Usuario> getByUsername(String login) {
		return repository.getByLogin(login);
	}

	public List<Usuario> getAll() {
		return repository.getAll();
	}

}
