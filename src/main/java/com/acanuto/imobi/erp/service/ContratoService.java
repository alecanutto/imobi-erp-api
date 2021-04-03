package com.acanuto.imobi.erp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.ContratoDTO;
import com.acanuto.imobi.erp.model.Contrato;
import com.acanuto.imobi.erp.repository.ContratoRepository;

@Component
public class ContratoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ContratoRepository repository;

	public Contrato save(ContratoDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do contrato é inválido!");
		}

		Contrato contrato = modelMapper.map(dto, Contrato.class);

		// verificação de alteração de registro
		if (contrato.getId() > 0 && !repository.existsById(contrato.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		return repository.save(contrato);
	}

	public Optional<Contrato> getById(long id) {
		return repository.findById(id);
	}

	public Iterable<Contrato> getAll() {
		return repository.findAll();
	}

	public List<Contrato> getAllByGrupo(String grupo) {
		return repository.findAllByGrupo(grupo);
	}

}
