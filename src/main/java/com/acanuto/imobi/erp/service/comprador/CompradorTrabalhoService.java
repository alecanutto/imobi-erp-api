package com.acanuto.imobi.erp.service.comprador;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.comprador.CompradorTrabalhoDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorTrabalho;
import com.acanuto.imobi.erp.repository.comprador.CompradorRepository;
import com.acanuto.imobi.erp.repository.comprador.CompradorTrabalhoRepository;

@Component
public class CompradorTrabalhoService {
	
	@Autowired
	private CompradorRepository compRepository;

	@Autowired
	private CompradorTrabalhoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public CompradorTrabalho save(CompradorTrabalhoDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!compRepository.existsById(dto.getCompradorId())) {
			throw new Exception("Comprador não cadastrado!");
		}
		
		CompradorTrabalho trabalho = modelMapper.map(dto, CompradorTrabalho.class);		
		return repository.save(trabalho);

	}

	public Optional<CompradorTrabalho> getByNome(String empresa) {
		return repository.findByEmpresa(empresa);
	}
	
	public Optional<CompradorTrabalho> getByCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}
	
	public Optional<CompradorTrabalho> getById(long id) {
		return repository.findById(id);
	}

	public Optional<CompradorTrabalho> getByCompradorId(long id) {
		return repository.findByCompradorId(id);
	}

}