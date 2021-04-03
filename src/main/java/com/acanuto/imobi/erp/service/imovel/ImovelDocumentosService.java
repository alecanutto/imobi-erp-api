package com.acanuto.imobi.erp.service.imovel;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.imovel.ImovelDocumentosDTO;
import com.acanuto.imobi.erp.model.imovel.ImovelDocumentos;
import com.acanuto.imobi.erp.repository.imovel.ImovelDocumentosRepository;

@Component
public class ImovelDocumentosService {

	@Autowired
	private ImovelDocumentosRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ImovelDocumentos save(ImovelDocumentosDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		ImovelDocumentos documentos = modelMapper.map(dto, ImovelDocumentos.class);
		
		return repository.save(documentos);

	}

	public Optional<ImovelDocumentos> getById(long id) {
		return repository.findById(id);
	}	
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}	

	public List<ImovelDocumentos> getAll() {
		return repository.findAll();
	}

	public List<ImovelDocumentos> getAllByImovelId(long imovelId) {
		return repository.findAllByImovelId(imovelId);
	}
	
	public List<ImovelDocumentos> getAllByCategoria(String categoria) {
		return repository.findAllByCategoria(categoria);
	}
	
	public Optional<ImovelDocumentos> getByTitulo(String titulo) {
		return repository.findByTitulo(titulo);
	}
	
}
