package com.acanuto.imobi.erp.repository.proprietario;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.proprietario.ProprietarioTrabalho;
import com.acanuto.imobi.erp.repository.PessoaTrabalhoRepository;

@Repository
public interface ProprietarioTrabalhoRepository extends PessoaTrabalhoRepository<ProprietarioTrabalho> {
	
	Optional<ProprietarioTrabalho> findByProprietarioId(@Param("proprietarioId") long proprietarioId);

}
