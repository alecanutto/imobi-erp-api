package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T> extends CrudRepository<T, Long> {

	List<T> findAll();

	<S extends T> S save(S entity);

	long count();

	void delete(T entity);

	void deleteById(final long entityId);

	@Query("SELECT * FROM {entityName}")
	T executeSql();

}
