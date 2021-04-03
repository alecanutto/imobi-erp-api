package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface PessoaRepository<T> extends CrudRepository<T, Long> {

	Optional<T> findByNome(@Param("nome") String nome);

	Optional<T> findByCpf(@Param("cpf") String cpf);

	boolean existsByCpf(@Param("cpf") String cpf);

}
