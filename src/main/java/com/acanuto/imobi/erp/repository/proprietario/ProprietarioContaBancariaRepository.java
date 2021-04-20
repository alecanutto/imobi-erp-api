package com.acanuto.imobi.erp.repository.proprietario;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.proprietario.ProprietarioContaBancaria;
import com.acanuto.imobi.erp.repository.PessoaContaBancariaRepository;

@Repository
public interface ProprietarioContaBancariaRepository extends PessoaContaBancariaRepository<ProprietarioContaBancaria> {
		
	@Query(value = "Select * from tb_proprietario_bancos where proprietario_id = :proprietarioId;")
	List<ProprietarioContaBancaria> findAllByProprietarioId(@Param("proprietarioId") long proprietarioId);

}
