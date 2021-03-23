package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface GenericRepository<T> extends Repository<T, Long> {

	
	List<T> findAll();

	void create(final T entity);

	T update(final T entity);

	<S extends T> S save(S entity);

	T findOne(final long id);

	Long count();

	void delete(T entity);

	void deleteById(final long entityId);

	boolean exists(final long id);

	@Query(":sql")
	T executeSql(String sql);

}
