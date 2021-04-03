package com.acanuto.imobi.erp.model.fiador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaConjugue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_fiador_conjugue")
public class FiadorConjugue extends PessoaConjugue {
	
	private long fiadorId;

}
