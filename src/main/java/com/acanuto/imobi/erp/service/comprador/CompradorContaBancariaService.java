package com.acanuto.imobi.erp.service.comprador;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.comprador.CompradorContaBancariaDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorContaBancaria;
import com.acanuto.imobi.erp.repository.comprador.CompradorContaBancariaRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.PessoaContaBancariaValidator;

@Component
public class CompradorContaBancariaService {
	
	@Autowired
	private ManipulateDB db;

	@Autowired
	private CompradorContaBancariaRepository repository;

	private PessoaContaBancariaValidator<CompradorContaBancaria> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public CompradorContaBancaria save(CompradorContaBancariaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados da conta bancária inválida!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		CompradorContaBancaria banco = modelMapper.map(dto, CompradorContaBancaria.class);
		pessoaValidator = new PessoaContaBancariaValidator<CompradorContaBancaria>(banco);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}

		// verifica se já existe um número pix para um mesmo cadastro
		String nome = (String) db.getField("select nome from tb_comprador_bancos where id <> " + banco.getId()
				+ " and comprador_id = " + banco.getCompradorId() + " and pix = '" + banco.getPix() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("Pix já cadastrado para o banco " + nome + "!");
		}
		
		return repository.save(banco);

	}

	public Optional<CompradorContaBancaria> getById(long id) {
		return repository.findById(id);
	}

	public Optional<CompradorContaBancaria> getByCompradorId(long id) {
		return repository.findByCompradorId(id);
	}

	public List<CompradorContaBancaria> getAllByCompradorId(long compradorId) {
		return repository.findAllByCompradorId(compradorId);
	}

}

