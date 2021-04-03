package com.acanuto.imobi.erp.repository.fiador;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.fiador.FiadorContaBancaria;
import com.acanuto.imobi.erp.repository.PessoaContaBancariaRepository;

@Repository
public interface FiadorContaBancariaRepository extends PessoaContaBancariaRepository<FiadorContaBancaria> {

	Optional<FiadorContaBancaria> findByFiadorId(@Param("fiadorId") long fiadorId);

	@Query(value = "Select * from tb_fiador_bancos where fiador_id = :fiadorId;")
	List<FiadorContaBancaria> findAllByFiadorId(@Param("fiadorId") long fiadorId);

}