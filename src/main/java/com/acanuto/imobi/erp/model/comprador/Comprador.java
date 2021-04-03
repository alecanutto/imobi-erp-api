package com.acanuto.imobi.erp.model.comprador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.Pessoa;

@Table(value = "tb_compradores")
public class Comprador extends Pessoa {

}
