package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	@Query(value = "select f.* from tb_funcionarios f inner join tb_usuarios u where u.login = :login;")
	Optional<Funcionario> findByLogin(@Param("login") String login);

	Optional<Funcionario> findByCpf(@Param("cpf") String cpf);

	boolean existsByCpf(@Param("cpf") String cpf);
}
