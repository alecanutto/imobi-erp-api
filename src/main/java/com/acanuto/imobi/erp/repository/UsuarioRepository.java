package com.acanuto.imobi.erp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acanuto.imobi.erp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query(value = "select exists (select id from tb_usuarios where login = :login);")
	boolean existsByLogin(@Param("login") String login);

	@Query(value = "select * from tb_usuarios where login = :login;")
	Optional<Usuario> getByLogin(@Param("login") String login);

	@Query(value = "select * from tb_usuarios;")
	List<Usuario> getAll();
}
