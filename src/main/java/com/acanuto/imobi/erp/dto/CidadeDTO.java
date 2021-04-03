package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {
	
	@ApiModelProperty(notes = "Código")
	private long id;

	@ApiModelProperty(notes = "UF")
	@Size(max = 2, message = "o campo uf deve conter no máximo 2 caracteres.")
	private String uf;
	
	@ApiModelProperty(notes = "Cidade")
	@Size(max = 100, message = "O campo cidade deve conter no máximo 100 caracteres.")
	private String cidade;
	
	@ApiModelProperty(notes = "CEP")
	@Size(max = 8, message = "O campo cep deve conter no máximo 8 dígitos.")
	private String cep;
	
	@ApiModelProperty(notes = "Código do IBGE")
	@Size(max = 7, message = "O campo código do ibge deve conter no máximo 7 dígitos.")
	private String codIbge;
	
}
