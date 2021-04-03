package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoDTO {

	@ApiModelProperty(notes = "Código")
	private long id;
	
	@ApiModelProperty(notes = "Grupo", required = true)
	@NotBlank(message = "O campo grupo é obrigatório.")
	@Size(max = 30, message = "O campo grupo deve conter no máximo 30 caracteres.")
	private String grupo;

	@ApiModelProperty(notes = "Título", required = true)
	@NotBlank(message = "O campo título é obrigatório.")
	@Size(max = 60, message = "O campo título deve conter no máximo 60 caracteres.")
	private String titulo;

	@ApiModelProperty(notes = "Descrição")
	private String descricao;
	
	@ApiModelProperty(notes = "Status")
	private boolean ativo;
	
}
