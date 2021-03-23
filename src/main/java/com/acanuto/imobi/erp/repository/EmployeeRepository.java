package com.acanuto.imobi.erp.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query(value = "select f.* from tbl_funcionarios f inner join tbl_usuarios u where u.campo1 = :username;")
	Optional<Employee> findByUsername(@Param("username") String username);

	@Query(value = "select * from tbl_funcionarios where campo3 = :cpf);")
	Optional<Employee> findByCpf(@Param("cpf") String cpf);

	@Query(value = "select exists (select campo0 from tbl_funcionarios where campo3 = :cpf);")
	boolean existsByCPF(@Param("cpf") String cpf);
}
