package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Caracteristicas;

@Repository
public interface CaracteristicasRepository extends CrudRepository<Caracteristicas, Long> {
	
	List<Caracteristicas> findAllByCategoria(String categoria);
	
	List<Caracteristicas> findAll();

}
