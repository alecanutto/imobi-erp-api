package com.acanuto.imobi.erp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_cidades")
public class Cidade {

	@Id
	private long id;

	private String codIbge;
	
	private String cep;
	
	private String uf;

	private String cidade;
	
	private String codUf;
	
}
