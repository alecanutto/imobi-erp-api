package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Banco;

@Repository
public interface BancoRepository extends CrudRepository<Banco, Long> {
	
	Optional<Banco> findByPix(@Param("pix") String pix);
	
}
