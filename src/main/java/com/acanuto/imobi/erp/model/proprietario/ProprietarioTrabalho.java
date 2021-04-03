package com.acanuto.imobi.erp.model.proprietario;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaTrabalho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_proprietario_trabalho")
public class ProprietarioTrabalho extends PessoaTrabalho {

	private long proprietarioId;
	
}
