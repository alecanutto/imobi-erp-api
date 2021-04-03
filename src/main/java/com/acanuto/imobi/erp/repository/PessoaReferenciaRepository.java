package com.acanuto.imobi.erp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface PessoaReferenciaRepository<T> extends CrudRepository<T, Long> {

	Optional<T> findByNome(@Param("nome") String nome);

	List<T> findByTipo(@Param("tipo") String tipo);

}