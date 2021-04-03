package com.acanuto.imobi.erp.repository.imovel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.imovel.ImovelTipo;

@Repository
public interface ImovelTipoRepository extends CrudRepository<ImovelTipo, Long> {

	List<ImovelTipo> findAll(); 	
	
}
