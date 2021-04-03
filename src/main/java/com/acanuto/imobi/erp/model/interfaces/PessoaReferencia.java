package com.acanuto.imobi.erp.model.interfaces;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class PessoaReferencia {

	@Id
	private long id;

	private String nome;

	private String fone;
	
	private String tipo;

	private String obs;
	
}
