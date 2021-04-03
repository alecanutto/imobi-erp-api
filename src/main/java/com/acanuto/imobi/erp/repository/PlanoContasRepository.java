package com.acanuto.imobi.erp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.PlanoContas;

@Repository
public interface PlanoContasRepository extends CrudRepository<PlanoContas, Long> {

	@Query(value = "select * from tb_plano_contas where left(codigo, 2) = :codigo;")
	List<PlanoContas> findAllByGrupo(@Param("codigo") String codigo);

	@Query(value = "select * from tb_plano_contas where tipo_conta = :tipo;")
	List<PlanoContas> findAllByTipo(@Param("tipo") int tipo);
		
	Optional<PlanoContas> findByDescricao(@Param("descricao") String descricao);
	
	@Query(value = "select * from tb_plano_contas where codigo = :codigo;")
	Optional<PlanoContas> findByCodigo(@Param("codigo") String codigo);

}
