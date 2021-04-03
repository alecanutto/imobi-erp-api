package com.acanuto.imobi.erp.service.comprador;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.comprador.CompradorDTO;
import com.acanuto.imobi.erp.model.comprador.Comprador;
import com.acanuto.imobi.erp.repository.comprador.CompradorRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.PessoaValidator;

@Component
public class CompradorService {

	@Autowired
	private ManipulateDB db;

	@Autowired
	private CompradorRepository repository;

	private PessoaValidator<Comprador> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public Comprador save(CompradorDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do comprador não informado!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		Comprador prop = modelMapper.map(dto, Comprador.class);
		pessoaValidator = new PessoaValidator<Comprador>(prop);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}

		String nome = (String) db.getField("select nome from tb_compradores where id <> " + prop.getId()
				+ " and cpf = '" + prop.getCpf() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("CPF já cadastrado para o comprador " + nome + "!");
		}
		
		return repository.save(prop);

	}

	public Optional<Comprador> getById(long id) {
		return repository.findById(id);
	}

	public Optional<Comprador> getByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Optional<Comprador> getByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Iterable<Comprador> getAll() {
		return repository.findAll();
	}
	
}
