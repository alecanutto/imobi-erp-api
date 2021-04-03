package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {
	
	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "UF")
	@Size(max = 2, message = "o campo uf deve conter no m�ximo 2 caracteres.")
	private String uf;
	
	@ApiModelProperty(notes = "Cidade")
	@Size(max = 100, message = "O campo cidade deve conter no m�ximo 100 caracteres.")
	private String cidade;
	
	@ApiModelProperty(notes = "CEP")
	@Size(max = 8, message = "O campo cep deve conter no m�ximo 8 d�gitos.")
	private String cep;
	
	@ApiModelProperty(notes = "C�digo do IBGE")
	@Size(max = 7, message = "O campo c�digo do ibge deve conter no m�ximo 7 d�gitos.")
	private String codIbge;
	
}
