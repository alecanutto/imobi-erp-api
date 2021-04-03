package com.acanuto.imobi.erp.model.comprador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaContaBancaria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_comprador_bancos")
public class CompradorContaBancaria extends PessoaContaBancaria {

	private long compradorId;
	
}
