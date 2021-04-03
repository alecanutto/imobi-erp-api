package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;
	
	@ApiModelProperty(notes = "Grupo", required = true)
	@NotBlank(message = "O campo grupo � obrigat�rio.")
	@Size(max = 30, message = "O campo grupo deve conter no m�ximo 30 caracteres.")
	private String grupo;

	@ApiModelProperty(notes = "T�tulo", required = true)
	@NotBlank(message = "O campo t�tulo � obrigat�rio.")
	@Size(max = 60, message = "O campo t�tulo deve conter no m�ximo 60 caracteres.")
	private String titulo;

	@ApiModelProperty(notes = "Descri��o")
	private String descricao;
	
	@ApiModelProperty(notes = "Status")
	private boolean ativo;
	
}
