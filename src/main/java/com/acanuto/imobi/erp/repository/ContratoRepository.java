package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Long> {
	
	@Query("Select * from tb_contratos where grupo = :grupo;")
	List<Contrato> findAllByGrupo(@Param("grupo") String grupo);
	
}
