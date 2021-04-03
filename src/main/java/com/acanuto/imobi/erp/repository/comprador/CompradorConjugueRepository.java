package com.acanuto.imobi.erp.repository.comprador;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.comprador.CompradorConjugue;
import com.acanuto.imobi.erp.repository.PessoaConjugueRepository;

@Repository
public interface CompradorConjugueRepository extends PessoaConjugueRepository<CompradorConjugue> {
	
	Optional<CompradorConjugue> findByCompradorId(@Param("fiadorId") long compradorId);

}
