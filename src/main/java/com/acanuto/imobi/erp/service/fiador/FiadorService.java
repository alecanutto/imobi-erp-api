package com.acanuto.imobi.erp.service.fiador;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.fiador.FiadorDTO;
import com.acanuto.imobi.erp.model.fiador.Fiador;
import com.acanuto.imobi.erp.repository.fiador.FiadorRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.PessoaValidator;

@Component
public class FiadorService {
	
	@Autowired
	private ManipulateDB db;

	@Autowired
	private FiadorRepository repository;

	private PessoaValidator<Fiador> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public Fiador save(FiadorDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do fiador não informado!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		Fiador prop = modelMapper.map(dto, Fiador.class);
		pessoaValidator = new PessoaValidator<Fiador>(prop);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}

		String nome = (String) db.getField("select nome from tb_fiadores where id <> " + prop.getId()
				+ " and cpf = '" + prop.getCpf() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("CPF já cadastrado para o fiador " + nome + "!");
		}
		
		return repository.save(prop);

	}

	public Optional<Fiador> getById(long id) {
		return repository.findById(id);
	}

	public Optional<Fiador> getByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Optional<Fiador> getByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Iterable<Fiador> getAll() {
		return repository.findAll();
	}

}
