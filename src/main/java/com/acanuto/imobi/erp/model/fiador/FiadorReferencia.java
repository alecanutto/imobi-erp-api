package com.acanuto.imobi.erp.model.fiador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaReferencia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_fiador_referencias")
public class FiadorReferencia extends PessoaReferencia {

	private long fiadorId;
	
}
