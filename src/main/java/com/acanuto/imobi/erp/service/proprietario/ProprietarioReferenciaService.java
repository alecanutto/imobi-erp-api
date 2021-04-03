package com.acanuto.imobi.erp.service.proprietario;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.proprietario.ProprietarioReferenciaDTO;
import com.acanuto.imobi.erp.model.proprietario.ProprietarioReferencia;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioRepository;
import com.acanuto.imobi.erp.repository.proprietario.ProprietarioReferenciaRepository;

@Component
public class ProprietarioReferenciaService {

	@Autowired
	private ProprietarioRepository propRepository;

	@Autowired
	private ProprietarioReferenciaRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ProprietarioReferencia save(ProprietarioReferenciaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		if (!propRepository.existsById(dto.getProprietarioId())) {
			throw new Exception("Proprietário não cadastrado!");
		}

		ProprietarioReferencia trabalho = modelMapper.map(dto, ProprietarioReferencia.class);

		return repository.save(trabalho);

	}

	public Optional<ProprietarioReferencia> getById(long id) {
		return repository.findById(id);
	}

	public Optional<ProprietarioReferencia> getByProprietarioId(long id) {
		return repository.findByProprietarioId(id);
	}

	public List<ProprietarioReferencia> getAllByProprietarioId(long proprietarioId) {
		return repository.findAllByProprietarioId(proprietarioId);
	}

}
