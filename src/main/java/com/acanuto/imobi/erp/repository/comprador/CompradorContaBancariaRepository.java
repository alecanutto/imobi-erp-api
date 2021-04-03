package com.acanuto.imobi.erp.repository.comprador;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.comprador.CompradorContaBancaria;
import com.acanuto.imobi.erp.repository.PessoaContaBancariaRepository;

@Repository
public interface CompradorContaBancariaRepository extends PessoaContaBancariaRepository<CompradorContaBancaria> {

	Optional<CompradorContaBancaria> findByCompradorId(@Param("compradorId") long compradorId);

	@Query(value = "Select * from tb_comprador_bancos where comprador_id = :compradorId;")
	List<CompradorContaBancaria> findAllByCompradorId(@Param("compradorId") long compradorId);

}