package com.acanuto.imobi.erp.service.comprador;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.comprador.CompradorConjugueDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorConjugue;
import com.acanuto.imobi.erp.repository.comprador.CompradorConjugueRepository;
import com.acanuto.imobi.erp.repository.comprador.CompradorRepository;
import com.acanuto.imobi.erp.validator.PessoaConjugueValidator;

@Component
public class CompradorConjugueService {
	
	@Autowired
	private CompradorRepository compradorRepository;

	@Autowired
	private CompradorConjugueRepository repository;

	private PessoaConjugueValidator<CompradorConjugue> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public CompradorConjugue save(CompradorConjugueDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!compradorRepository.existsById(dto.getCompradorId())) {
			throw new Exception("Comprador não cadastrado!");
		}
		
		CompradorConjugue conjugue = modelMapper.map(dto, CompradorConjugue.class);
		pessoaValidator = new PessoaConjugueValidator<CompradorConjugue>(conjugue);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}	
		
		return repository.save(conjugue);

	}

	public Optional<CompradorConjugue> getById(long id) {
		return repository.findById(id);
	}

	public Optional<CompradorConjugue> getByCompradorId(long id) {
		return repository.findByCompradorId(id);
	}

}