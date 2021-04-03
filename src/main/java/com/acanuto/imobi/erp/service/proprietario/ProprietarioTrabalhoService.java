package com.acanuto.imobi.erp.service.proprietario;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioTrabalhoDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioTrabalho;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioRepository;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioTrabalhoRepository;

@Component
public class ProprietarioTrabalhoService {
	
	@Autowired
	private ProprietarioRepository propRepository;

	@Autowired
	private ProprietarioTrabalhoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ProprietarioTrabalho save(ProprietarioTrabalhoDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!propRepository.existsById(dto.getProprietarioId())) {
			throw new Exception("Proprietário não cadastrado!");
		}
		
		ProprietarioTrabalho trabalho = modelMapper.map(dto, ProprietarioTrabalho.class);
		
		return repository.save(trabalho);

	}
	
	public Optional<ProprietarioTrabalho> getByNome(String empresa) {
		return repository.findByEmpresa(empresa);
	}
	
	public Optional<ProprietarioTrabalho> getByCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}

	public Optional<ProprietarioTrabalho> getById(long id) {
		return repository.findById(id);
	}

	public Optional<ProprietarioTrabalho> getByProprietarioId(long id) {
		return repository.findByProprietarioId(id);
	}

}