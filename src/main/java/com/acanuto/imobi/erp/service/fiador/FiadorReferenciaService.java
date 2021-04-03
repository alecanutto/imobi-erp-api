package com.acanuto.imobi.erp.service.fiador;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.fiador.FiadorReferenciaDTO;
import com.acanuto.imobi.erp.model.fiador.FiadorReferencia;
import com.acanuto.imobi.erp.repository.fiador.FiadorRepository;
import com.acanuto.imobi.erp.repository.fiador.FiadorReferenciaRepository;

@Component
public class FiadorReferenciaService {

	@Autowired
	private FiadorRepository fiadorRepository;

	@Autowired
	private FiadorReferenciaRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public FiadorReferencia save(FiadorReferenciaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!fiadorRepository.existsById(dto.getFiadorId())) {
			throw new Exception("Fiador não cadastrado!");
		}

		FiadorReferencia trabalho = modelMapper.map(dto, FiadorReferencia.class);

		return repository.save(trabalho);

	}

	public Optional<FiadorReferencia> getById(long id) {
		return repository.findById(id);
	}

	public Optional<FiadorReferencia> getByFiadorId(long id) {
		return repository.findByFiadorId(id);
	}

	public List<FiadorReferencia> getAllByFiadorId(long fiadorId) {
		return repository.findAllByFiadorId(fiadorId);
	}

}
