package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	Optional<Funcionario> findByUsuario(@Param("usuario") String usuario);

	Optional<Funcionario> findByCpf(@Param("cpf") String cpf);
	
	boolean existsByCpf(@Param("cpf") String cpf);
	
	boolean existsByUsuario(@Param("usuario") String usuario);
}
