package com.acanuto.imobi.erp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acanuto.imobi.erp.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
