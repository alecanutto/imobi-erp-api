package com.acanuto.imobi.erp.service.proprietario;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioConjugueDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioConjugue;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioConjugueRepository;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioRepository;
import com.acanuto.imobi.erp.validator.PessoaConjugueValidator;

@Component
public class ProprietarioConjugueService {
	
	@Autowired
	private ProprietarioRepository propRepository;

	@Autowired
	private ProprietarioConjugueRepository repository;

	private PessoaConjugueValidator<ProprietarioConjugue> pessoaValidator;

	@Autowired
	private ModelMapper modelMapper;

	public ProprietarioConjugue save(ProprietarioConjugueDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!propRepository.existsById(dto.getProprietarioId())) {
			throw new Exception("Proprietário não cadastrado!");
		}
		
		ProprietarioConjugue conjugue = modelMapper.map(dto, ProprietarioConjugue.class);
		pessoaValidator = new PessoaConjugueValidator<ProprietarioConjugue>(conjugue);

		if (!pessoaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(pessoaValidator.getListErrors(), ","));
		}	
		
		return repository.save(conjugue);

	}

	public Optional<ProprietarioConjugue> getById(long id) {
		return repository.findById(id);
	}

	public Optional<ProprietarioConjugue> getByProprietarioId(long id) {
		return repository.findByProprietarioId(id);
	}

}