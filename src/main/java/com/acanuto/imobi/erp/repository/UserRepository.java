package com.acanuto.imobi.erp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acanuto.imobi.erp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "select exists (select campo0 from tbl_usuarios where campo2 = :username);")
	boolean existsByUsername(@Param("username") String username);

	@Query(value = "select * from tbl_usuarios where campo2 = :username;")
	Optional<User> getByUsername(@Param("username") String username);

	@Query(value = "select * from tbl_usuarios where campo0 = :id);")
	Optional<User> getById(@Param("id") String id);

	@Query(value = "select * from tbl_usuarios;")
	List<User> getAll();
}
