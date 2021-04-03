package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface PessoaTrabalhoRepository<T> extends CrudRepository<T, Long> {

	Optional<T> findByEmpresa(@Param("empresa") String empresa);

	Optional<T> findByCnpj(@Param("cnpj") String cnpj);

}