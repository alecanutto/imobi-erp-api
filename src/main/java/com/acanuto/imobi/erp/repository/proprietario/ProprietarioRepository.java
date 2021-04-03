package com.acanuto.imobi.erp.repository.proprietario;

import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.proprietario.Proprietario;
import com.acanuto.imobi.erp.repository.PessoaRepository;

@Repository
public interface ProprietarioRepository extends PessoaRepository<Proprietario> {

}
