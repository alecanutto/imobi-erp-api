package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface PessoaContaBancariaRepository<T> extends CrudRepository<T, Long> {
	
	Optional<T> findByPix(@Param("pix") String pix);

}
