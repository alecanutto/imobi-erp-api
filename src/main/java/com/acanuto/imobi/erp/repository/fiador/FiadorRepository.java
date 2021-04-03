package com.acanuto.imobi.erp.repository.fiador;

import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.fiador.Fiador;
import com.acanuto.imobi.erp.repository.PessoaRepository;

@Repository
public interface FiadorRepository extends PessoaRepository<Fiador> {

}
