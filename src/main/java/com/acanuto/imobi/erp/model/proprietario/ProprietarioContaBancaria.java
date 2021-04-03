package com.acanuto.imobi.erp.model.proprietario;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaContaBancaria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_proprietario_bancos")
public class ProprietarioContaBancaria extends PessoaContaBancaria {

	private long proprietarioId;
	
}
