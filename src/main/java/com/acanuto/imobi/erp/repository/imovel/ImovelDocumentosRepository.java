package com.acanuto.imobi.erp.repository.imovel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.acanuto.imobi.erp.model.imovel.ImovelDocumentos;

public interface ImovelDocumentosRepository extends CrudRepository<ImovelDocumentos, Long> {

	List<ImovelDocumentos> findAll(); 	
	
	List<ImovelDocumentos> findAllByImovelId(long imovelId); 	
	
	List<ImovelDocumentos> findAllByCategoria(String categoria); 	
	
	Optional<ImovelDocumentos> findByTitulo(String titulo);
	
}
