package com.acanuto.imobi.erp.service.proprietario;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioDTO;
import com.acanuto.imobi.erp.model.proprietario.Proprietario;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.PessoaValidator;

@Component
public class ProprietarioService {

	@Autowired
	private ManipulateDB db;

	@Autowired
	private ProprietarioRepository repository;

	private PessoaValidator<Proprietario> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public Proprietario save(ProprietarioDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do propriet�rio n�o informado!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro n�o encontrado!");
		}

		Proprietario prop = modelMapper.map(dto, Proprietario.class);
		pessoaValidator = new PessoaValidator<Proprietario>(prop);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}

		String nome = (String) db.getField("select nome from tb_proprietarios where id <> " + prop.getId()
				+ " and cpf = '" + prop.getCpf() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("CPF j� cadastrado para o propriet�rio " + nome + "!");
		}
		
		return repository.save(prop);

	}

	public Optional<Proprietario> getById(long id) {
		return repository.findById(id);
	}

	public Optional<Proprietario> getByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Optional<Proprietario> getByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Iterable<Proprietario> getAll() {
		return repository.findAll();
	}

}
