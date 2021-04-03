package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaracteristicasDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;
	
	@ApiModelProperty(notes = "Categoria", required = true)
	@NotBlank(message = "o campo categoria � obrigat�rio.")
	@Size(max = 30, message = "o campo uf deve conter no m�ximo 30 caracteres.")
	private String categoria;

	@ApiModelProperty(notes = "Descri��o", required = true)
	@NotBlank(message = "o campo descri��o � obrigat�rio.")
	@Size(max = 50, message = "o campo descri��o deve conter no m�ximo 50 caracteres.")
	private String descricao;

	@ApiModelProperty(notes = "Ativo?")
	private boolean ativo;

}
