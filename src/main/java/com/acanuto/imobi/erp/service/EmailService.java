package com.acanuto.imobi.erp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.EmailDTO;
import com.acanuto.imobi.erp.model.Email;
import com.acanuto.imobi.erp.repository.EmailRepository;

@Component
public class EmailService {

//	@Autowired
//	private PasswordEncoder encoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmailRepository repository;

	public void save(EmailDTO email) throws Exception {

		if (email == null) {
			throw new Exception("Dados de email não informado!");
		}

		if (repository.existsById(email.getId())) {
			throw new Exception("Email já cadastrado!");
		}
		
		Email e = modelMapper.map(email, Email.class);
		
//		String passwordCript = encoder.encode(email.getSenha());
//		email.setSenha(passwordCript);
		
		repository.save(e);
	}
	
	public Optional<Email> getById(long id) {
		return repository.findById(id);
	}
		
	public boolean existsById(long id) {
		return repository.existsById(id);
	}

	public Iterable<Email> getAll() {
		return repository.findAll();
	}
	
}
