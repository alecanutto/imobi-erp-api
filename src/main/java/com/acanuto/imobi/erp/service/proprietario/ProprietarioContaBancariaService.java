package com.acanuto.imobi.erp.service.proprietario;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioContaBancariaDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioContaBancaria;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioContaBancariaRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.PessoaContaBancariaValidator;

@Component
public class ProprietarioContaBancariaService {
	
	@Autowired
	private ManipulateDB db;

	@Autowired
	private ProprietarioContaBancariaRepository repository;

	private PessoaContaBancariaValidator<ProprietarioContaBancaria> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public ProprietarioContaBancaria save(ProprietarioContaBancariaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados da conta bancária inválida!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		ProprietarioContaBancaria banco = modelMapper.map(dto, ProprietarioContaBancaria.class);
		pessoaValidator = new PessoaContaBancariaValidator<ProprietarioContaBancaria>(banco);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}

		// verifica se já existe um número pix para um mesmo cadastro
		String nome = (String) db.getField("select nome_banco from tb_proprietario_bancos where id <> " + banco.getId()
				+ " and proprietario_id = " + banco.getProprietarioId() + " and pix = '" + banco.getPix() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("Pix já cadastrado para o banco " + nome + "!");
		}
		
		return repository.save(banco);

	}

	public Optional<ProprietarioContaBancaria> getById(long id) {
		return repository.findById(id);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}


	public List<ProprietarioContaBancaria> getAllByProprietarioId(long proprietarioId) {
		return repository.findAllByProprietarioId(proprietarioId);
	}

}
