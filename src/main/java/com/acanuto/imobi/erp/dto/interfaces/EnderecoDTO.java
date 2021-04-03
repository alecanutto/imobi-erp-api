package com.acanuto.imobi.erp.dto.interfaces;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EnderecoDTO {
	
	@ApiModelProperty(notes = "Endere�o")
	@Size(max = 150, message = "O campo endere�o deve conter no m�ximo 150 caracteres.")
	private String endereco;
	
	@ApiModelProperty(notes = "N�mero")
	@Size(max = 10, message = "O campo n�mero deve conter no m�ximo 10 caracteres.")
	private String numero;
	
	@ApiModelProperty(notes = "Bairro")
	@Size(max = 100, message = "O campo bairro deve conter no m�ximo 100 caracteres.")
	private String bairro;
	
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
