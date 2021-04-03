package com.acanuto.imobi.erp.model.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Endereco {
	
	private String endereco;

	private String numero;

	private String bairro;
	
	private String complemento;

	private String uf;

	private String cidade;

	private String cep;

	private String codIbge;

}
