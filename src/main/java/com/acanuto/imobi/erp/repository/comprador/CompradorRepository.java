package com.acanuto.imobi.erp.repository.comprador;

import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.comprador.Comprador;
import com.acanuto.imobi.erp.repository.PessoaRepository;

@Repository
public interface CompradorRepository extends PessoaRepository<Comprador> {

}
