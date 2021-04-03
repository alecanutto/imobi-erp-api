package com.acanuto.imobi.erp.model.proprietario;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaConjugue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_proprietario_conjugue")
public class ProprietarioConjugue extends PessoaConjugue {
	
	private long proprietarioId;

}
