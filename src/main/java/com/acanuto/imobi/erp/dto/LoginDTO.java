package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class LoginDTO {

	@ApiModelProperty(notes = "Nome do usuário")
	@NotBlank(message = "Usuário deve ser preenchido corretamente.")
	private String usuario;

	@ApiModelProperty(notes = "Senha do usuário")
	@NotBlank(message = "Senha deve ser preenchida corretamente.")
	private String senha;

}
