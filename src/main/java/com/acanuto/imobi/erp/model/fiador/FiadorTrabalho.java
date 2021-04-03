package com.acanuto.imobi.erp.model.fiador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaTrabalho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_fiador_trabalho")
public class FiadorTrabalho extends PessoaTrabalho {

	private long fiadorId;
	
}
