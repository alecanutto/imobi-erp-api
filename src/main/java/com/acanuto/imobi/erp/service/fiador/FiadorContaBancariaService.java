package com.acanuto.imobi.erp.service.fiador;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.fiador.FiadorContaBancariaDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorContaBancaria;
import com.acanuto.imobi.erp.repository.fiador.FiadorContaBancariaRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.PessoaContaBancariaValidator;

@Component
public class FiadorContaBancariaService {
	
	@Autowired
	private ManipulateDB db;

	@Autowired
	private FiadorContaBancariaRepository repository;

	private PessoaContaBancariaValidator<FiadorContaBancaria> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public FiadorContaBancaria save(FiadorContaBancariaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados da conta bancária inválida!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		FiadorContaBancaria banco = modelMapper.map(dto, FiadorContaBancaria.class);
		pessoaValidator = new PessoaContaBancariaValidator<FiadorContaBancaria>(banco);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}

		// verifica se já existe um número pix para um mesmo cadastro
		String nome = (String) db.getField("select nome from tb_fiador_bancos where id <> " + banco.getId()
				+ " and fiador_id = " + banco.getFiadorId() + " and pix = '" + banco.getPix() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("Pix já cadastrado para o banco " + nome + "!");
		}
		
		return repository.save(banco);

	}

	public Optional<FiadorContaBancaria> getById(long id) {
		return repository.findById(id);
	}

	public Optional<FiadorContaBancaria> getByFiadorId(long id) {
		return repository.findByFiadorId(id);
	}

	public List<FiadorContaBancaria> getAllByFiadorId(long fiadorId) {
		return repository.findAllByFiadorId(fiadorId);
	}

}