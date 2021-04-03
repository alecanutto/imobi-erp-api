package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class PermissaoAcessoDTO {

	@ApiModelProperty(notes = "C�digo da permiss�o")
	private long id;

	@ApiModelProperty(notes = "C�digo do usu�rio", required = true)
	@Positive(message = "C�digo do usu�rio deve ser preenchido corretamente.")
	private long usuario;

	@ApiModelProperty(notes = "Descri��o da permiss�o", required = true)
	@NotBlank(message = "Descri��o da permiss�o deve ser preenchida corretamente.")
	@Size(max = 4, message = "Descri��o deve conter no m�ximo 4 caracteres.")
	private String descricao;

	@ApiModelProperty(notes = "Status da permiss�o")
	private boolean permite;

}
