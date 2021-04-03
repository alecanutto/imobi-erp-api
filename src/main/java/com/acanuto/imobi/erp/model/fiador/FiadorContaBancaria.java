package com.acanuto.imobi.erp.model.fiador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaContaBancaria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_fiador_bancos")
public class FiadorContaBancaria extends PessoaContaBancaria {

	private long fiadorId;
	
}
