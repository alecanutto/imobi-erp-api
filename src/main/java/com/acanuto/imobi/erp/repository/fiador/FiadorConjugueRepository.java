package com.acanuto.imobi.erp.repository.fiador;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.fiador.FiadorConjugue;
import com.acanuto.imobi.erp.repository.PessoaConjugueRepository;

@Repository
public interface FiadorConjugueRepository extends PessoaConjugueRepository<FiadorConjugue> {
	
	Optional<FiadorConjugue> findByFiadorId(@Param("fiadorId") long fiadorId);

}
