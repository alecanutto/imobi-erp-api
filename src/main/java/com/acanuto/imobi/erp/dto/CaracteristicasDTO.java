package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaracteristicasDTO {

	@ApiModelProperty(notes = "Código")
	private long id;
	
	@ApiModelProperty(notes = "Categoria", required = true)
	@NotBlank(message = "o campo categoria é obrigatório.")
	@Size(max = 30, message = "o campo uf deve conter no máximo 30 caracteres.")
	private String categoria;

	@ApiModelProperty(notes = "Descrição", required = true)
	@NotBlank(message = "o campo descrição é obrigatório.")
	@Size(max = 50, message = "o campo descrição deve conter no máximo 50 caracteres.")
	private String descricao;

	@ApiModelProperty(notes = "Ativo?")
	private boolean ativo;

}
