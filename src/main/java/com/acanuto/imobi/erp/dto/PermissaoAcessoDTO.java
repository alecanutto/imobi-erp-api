package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class PermissaoAcessoDTO {

	@ApiModelProperty(notes = "Código da permissão")
	private long id;

	@ApiModelProperty(notes = "Código do usuário", required = true)
	@Positive(message = "Código do usuário deve ser preenchido corretamente.")
	private long usuario;

	@ApiModelProperty(notes = "Descrição da permissão", required = true)
	@NotBlank(message = "Descrição da permissão deve ser preenchida corretamente.")
	@Size(max = 4, message = "Descrição deve conter no máximo 4 caracteres.")
	private String descricao;

	@ApiModelProperty(notes = "Status da permissão")
	private boolean permite;

}
