package com.acanuto.imobi.erp.dto.interfaces;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EnderecoDTO {
	
	@ApiModelProperty(notes = "Endereço")
	@Size(max = 150, message = "O campo endereço deve conter no máximo 150 caracteres.")
	private String endereco;
	
	@ApiModelProperty(notes = "Número")
	@Size(max = 10, message = "O campo número deve conter no máximo 10 caracteres.")
	private String numero;
	
	@ApiModelProperty(notes = "Bairro")
	@Size(max = 100, message = "O campo bairro deve conter no máximo 100 caracteres.")
	private String bairro;
	
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
