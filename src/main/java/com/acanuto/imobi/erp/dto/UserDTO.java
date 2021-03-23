package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	@ApiModelProperty(notes = "Nome do usuário")
	@NotBlank(message = "Usuário deve ser preenchido corretamente.")
	private String usuario;

	@ApiModelProperty(notes = "Senha do usuário")
	@NotBlank(message = "Senha deve ser preenchida corretamente.")
	private String senha;
	
	@ApiModelProperty(notes = "Status do usuário")
	private boolean ativo;

}
