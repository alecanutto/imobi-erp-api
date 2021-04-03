package com.acanuto.imobi.erp.service.imovel;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.imovel.ImovelCaracteristicasDTO;
import com.acanuto.imobi.erp.model.imovel.ImovelCaracteristicas;
import com.acanuto.imobi.erp.repository.imovel.ImovelCaracteristicasRepository;

@Component
public class ImovelCaracteristicasService {

	@Autowired
	private ImovelCaracteristicasRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ImovelCaracteristicas save(ImovelCaracteristicasDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		ImovelCaracteristicas caracteristicas = modelMapper.map(dto, ImovelCaracteristicas.class);
		
		return repository.save(caracteristicas);

	}

	public Optional<ImovelCaracteristicas> getById(long id) {
		return repository.findById(id);
	}	
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}	

	public List<ImovelCaracteristicas> getAll() {
		return repository.findAll();
	}

	public List<ImovelCaracteristicas> getAllByImovelId(long imovelId) {
		return repository.findAllByImovelId(imovelId);
	}
	
}
