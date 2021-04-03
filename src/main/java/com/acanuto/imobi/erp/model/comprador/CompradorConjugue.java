package com.acanuto.imobi.erp.model.comprador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaConjugue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_comprador_conjugue")
public class CompradorConjugue extends PessoaConjugue {
	
	private long compradorId;

}
