package com.acanuto.imobi.erp.repository.imovel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.acanuto.imobi.erp.model.imovel.ImovelCaracteristicas;

public interface ImovelCaracteristicasRepository extends CrudRepository<ImovelCaracteristicas, Long> {
	
	List<ImovelCaracteristicas> findAll(); 	
	
	List<ImovelCaracteristicas> findAllByImovelId(long imovelId); 	
	
}
