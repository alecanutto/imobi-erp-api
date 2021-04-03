package com.acanuto.imobi.erp.model.proprietario;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.Pessoa;

@Table(value = "tb_proprietarios")
public class Proprietario extends Pessoa {
}
