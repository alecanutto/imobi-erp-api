package com.acanuto.imobi.erp.repository.proprietario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.proprietario.ProprietarioReferencia;
import com.acanuto.imobi.erp.repository.PessoaReferenciaRepository;

@Repository
public interface ProprietarioReferenciaRepository extends PessoaReferenciaRepository<ProprietarioReferencia> {

	Optional<ProprietarioReferencia> findByProprietarioId(@Param("proprietarioId") long proprietarioId);

	@Query(value = "Select * from tb_proprietario_bancos where proprietario_id = :proprietarioId;")
	List<ProprietarioReferencia> findAllByProprietarioId(@Param("proprietarioId") long proprietarioId);

}
