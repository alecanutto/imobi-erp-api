package com.acanuto.imobi.erp.model.proprietario;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaReferencia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_proprietario_referencias")
public class ProprietarioReferencia extends PessoaReferencia {

	private long proprietarioId;
	
}
