package com.acanuto.imobi.erp.model.comprador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaReferencia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_comprador_referencias")
public class CompradorReferencia extends PessoaReferencia {

	private long compradorId;
	
}
