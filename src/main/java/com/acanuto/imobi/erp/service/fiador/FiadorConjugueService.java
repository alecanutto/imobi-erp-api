package com.acanuto.imobi.erp.service.fiador;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.fiador.FiadorConjugueDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorConjugue;
import com.acanuto.imobi.erp.repository.fiador.FiadorConjugueRepository;
import com.acanuto.imobi.erp.repository.fiador.FiadorRepository;
import com.acanuto.imobi.erp.validator.PessoaConjugueValidator;

@Component
public class FiadorConjugueService {
	
	@Autowired
	private FiadorRepository fiadorRepository;

	@Autowired
	private FiadorConjugueRepository repository;

	private PessoaConjugueValidator<FiadorConjugue> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public FiadorConjugue save(FiadorConjugueDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!fiadorRepository.existsById(dto.getFiadorId())) {
			throw new Exception("Fiador não cadastrado!");
		}
		
		FiadorConjugue conjugue = modelMapper.map(dto, FiadorConjugue.class);
		pessoaValidator = new PessoaConjugueValidator<FiadorConjugue>(conjugue);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}	
		
		return repository.save(conjugue);

	}

	public Optional<FiadorConjugue> getById(long id) {
		return repository.findById(id);
	}

	public Optional<FiadorConjugue> getByFiadorId(long id) {
		return repository.findByFiadorId(id);
	}

}