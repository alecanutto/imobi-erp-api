package com.acanuto.imobi.erp.repository.fiador;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.fiador.FiadorTrabalho;
import com.acanuto.imobi.erp.repository.PessoaTrabalhoRepository;

@Repository
public interface FiadorTrabalhoRepository extends PessoaTrabalhoRepository<FiadorTrabalho> {
	
	Optional<FiadorTrabalho> findByFiadorId(@Param("fiadorId") long fiadorId);

}
