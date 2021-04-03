package com.acanuto.imobi.erp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.CaracteristicasDTO;
import com.acanuto.imobi.erp.model.Caracteristicas;
import com.acanuto.imobi.erp.repository.CaracteristicasRepository;

@Component
public class CaracteristicasService {

	@Autowired
	private CaracteristicasRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Caracteristicas save(CaracteristicasDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		Caracteristicas caracteristicas = modelMapper.map(dto, Caracteristicas.class);
		return repository.save(caracteristicas);

	}

	public Optional<Caracteristicas> getById(long id) {
		return repository.findById(id);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}

	public List<Caracteristicas> getAllByCategoria(String categoria) {
		return repository.findAllByCategoria(categoria);
	}

	public List<Caracteristicas> getAll() {
		return repository.findAll();
	}

}
