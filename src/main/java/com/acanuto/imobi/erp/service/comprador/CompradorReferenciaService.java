package com.acanuto.imobi.erp.service.comprador;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.comprador.CompradorReferenciaDTO;
import com.acanuto.imobi.erp.model.comprador.CompradorReferencia;
import com.acanuto.imobi.erp.repository.comprador.CompradorRepository;
import com.acanuto.imobi.erp.repository.comprador.CompradorReferenciaRepository;

@Component
public class CompradorReferenciaService {

	@Autowired
	private CompradorRepository compradorRepository;

	@Autowired
	private CompradorReferenciaRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public CompradorReferencia save(CompradorReferenciaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!compradorRepository.existsById(dto.getCompradorId())) {
			throw new Exception("Comprador não cadastrado!");
		}

		CompradorReferencia trabalho = modelMapper.map(dto, CompradorReferencia.class);

		return repository.save(trabalho);

	}

	public Optional<CompradorReferencia> getById(long id) {
		return repository.findById(id);
	}

	public Optional<CompradorReferencia> getByCompradorId(long id) {
		return repository.findByCompradorId(id);
	}

	public List<CompradorReferencia> getAllByCompradorId(long compradorId) {
		return repository.findAllByCompradorId(compradorId);
	}

}
