package com.acanuto.imobi.erp.model.comprador;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.PessoaTrabalho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(value = "tb_comprador_trabalho")
public class CompradorTrabalho extends PessoaTrabalho {

	private long compradorId;
	
}
