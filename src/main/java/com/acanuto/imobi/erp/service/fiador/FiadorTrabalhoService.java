package com.acanuto.imobi.erp.service.fiador;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.fiador.FiadorTrabalhoDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorTrabalho;
import com.acanuto.imobi.erp.repository.fiador.FiadorRepository;
import com.acanuto.imobi.erp.repository.fiador.FiadorTrabalhoRepository;

@Component
public class FiadorTrabalhoService {
	
	@Autowired
	private FiadorRepository propRepository;

	@Autowired
	private FiadorTrabalhoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public FiadorTrabalho save(FiadorTrabalhoDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!propRepository.existsById(dto.getFiadorId())) {
			throw new Exception("Fiador não cadastrado!");
		}
		
		FiadorTrabalho trabalho = modelMapper.map(dto, FiadorTrabalho.class);
		
		return repository.save(trabalho);

	}
	
	public Optional<FiadorTrabalho> getByNome(String empresa) {
		return repository.findByEmpresa(empresa);
	}
	
	public Optional<FiadorTrabalho> getByCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}

	public Optional<FiadorTrabalho> getById(long id) {
		return repository.findById(id);
	}

	public Optional<FiadorTrabalho> getByFiadorId(long id) {
		return repository.findByFiadorId(id);
	}

}