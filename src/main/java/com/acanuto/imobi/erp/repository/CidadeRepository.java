package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long> {
	
	@Query("select distinct uf from tb_cidades;")
	List<Cidade> findAllUf();
	
	@Query("select * from tb_cidades where uf = :uf;")
	List<Cidade> findAllByUf(@Param("uf") String uf);
	
	Cidade findByUfAndCidadeStartingWith(@Param("uf") String uf, @Param("cidade") String cidade);
		
}
