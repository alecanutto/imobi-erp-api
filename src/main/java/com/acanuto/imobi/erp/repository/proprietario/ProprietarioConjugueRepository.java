package com.acanuto.imobi.erp.repository.proprietario;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.proprietario.ProprietarioConjugue;
import com.acanuto.imobi.erp.repository.PessoaConjugueRepository;

@Repository
public interface ProprietarioConjugueRepository extends PessoaConjugueRepository<ProprietarioConjugue> {
	
	Optional<ProprietarioConjugue> findByProprietarioId(@Param("proprietarioId") long proprietarioId);

}
