package com.acanuto.imobi.erp.repository.comprador;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.comprador.CompradorTrabalho;
import com.acanuto.imobi.erp.repository.PessoaTrabalhoRepository;

@Repository
public interface CompradorTrabalhoRepository extends PessoaTrabalhoRepository<CompradorTrabalho> {
	
	Optional<CompradorTrabalho> findByCompradorId(@Param("compradorId") long compradorId);

}
