package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acanuto.imobi.erp.model.UserPermissions;

public interface UserPermissionsRepository extends CrudRepository<UserPermissions, Long> {

	@Query(value = "select * from tbl_permissoes where campo2 = :userId;")
	List<UserPermissions> getAllByUserId(@Param("userId") long userId);

}
